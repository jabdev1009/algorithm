package swea_1949_등산로조성;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int N,K,maxH,ans;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++, sb.append('\n')) {
			sb.append('#').append(tc).append(' ');
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			ans = 0;
			maxH = 0;
			
			map = new int[N][N];
			visited = new boolean[N][N];
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					int num = Integer.parseInt(st.nextToken());
					map[i][j] = num;
					if(num > maxH) {
						maxH = num;
					}
				}
			}
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j] == maxH) {
						dfs(j, i, 1, false);
					}
				}
			}
			sb.append(ans);
		}
		System.out.println(sb);
	}
	
	static void dfs(int x, int y, int dist, boolean isUsed) {
		if(dist > ans) ans = dist;
		visited[y][x] = true;
		for(int i=0; i<4; i++) {
			int xx = x + dx[i];
			int yy = y + dy[i];
			
			if(!bound(xx, yy) || visited[yy][xx]) continue;
			
			if(map[yy][xx] < map[y][x]) {
				dfs(xx, yy, dist+1, isUsed);
			} else if(map[yy][xx] - K < map[y][x] && !isUsed) {
				int tmp = map[yy][xx];
				map[yy][xx] = map[y][x]-1;
				dfs(xx, yy, dist+1, !isUsed);
				map[yy][xx] = tmp;
			}
		}
		visited[y][x] = false;
	}
	static boolean bound(int x, int y) {
		return x>=0&&y>=0&&x<N&&y<N;
	}
}
