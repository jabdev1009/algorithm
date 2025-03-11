package boj_14940_쉬운최단거리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static int startX;
	static int startY;
	
	static int[][] map;
	static boolean[][] visited;
	static int[][] result;
	
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		result = new int[n][m];
		visited = new boolean[n][m];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				int num = Integer.parseInt(st.nextToken());
				map[i][j] = num;
				result[i][j] = num;
				if(num == 2) {
					startX = j;
					startY = i;
				}
			}
		}
		bfs(startX,startY,0);
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				int num = result[i][j];
				if(num == -2) {
					num = 1;
				} else if(num == 1) {
					num = -1;
				}
				System.out.print(num+" ");
			}
			System.out.println();
		}
		
	}
	static void bfs(int x, int y, int time) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {x, y, 0});
		visited[y][x] = true;
		
		while(!queue.isEmpty()) {
			int[] arr = queue.poll();
			int xx = arr[0];
			int yy = arr[1];
			int now = arr[2];
			result[yy][xx] = (now==1? -2: now);
			for(int i=0; i<4; i++) {
				int xxx = xx+dx[i];
				int yyy = yy+dy[i];
				if(bound(xxx, yyy) && !visited[yyy][xxx] && map[yyy][xxx] == 1) {
					visited[yyy][xxx] = true;
					queue.add(new int[] {xxx, yyy, now+1});
				}
			}
		}
	}
	static boolean bound(int x, int y) {
		return x>=0&&x<m&&y>=0&&y<n;
	}
}
