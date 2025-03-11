package swea_7733_치즈도둑;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int n;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb;
		int T = Integer.parseInt(st.nextToken());
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");
			n = Integer.parseInt(st.nextToken());
			map = new int[n][n];
			visited = new boolean[n][n];
			
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int maxCnt = 0;
			for(int day=1; day<=100; day++) {
				int count = 0;
				setVisited(day);
				for(int i=0; i<n; i++) {
					for(int j=0; j<n; j++) {
						if(!visited[i][j]) {
							dfs(j,i);
							count++;
						}
					}
				}
				if(count > maxCnt) {
					maxCnt = count;
				}
			}
			sb.append(maxCnt);
			System.out.println(sb);
		}
	}
	
	static void setVisited(int day) {
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(map[i][j] > day) {
					visited[i][j] = false;
				} else {
					visited[i][j] = true;
				}
			}
		}
	}
	static void dfs(int x, int y) {
		for(int k=0; k<4; k++) {
			int xx = x + dx[k];
			int yy = y + dy[k];
			if(bound(xx, yy) && !visited[yy][xx]) {
				visited[yy][xx] = true;
				dfs(xx, yy);
			}
		}
	}
	static boolean bound(int x, int y) {
		return x>=0&&x<n&&y>=0&&y<n;
	}
}
