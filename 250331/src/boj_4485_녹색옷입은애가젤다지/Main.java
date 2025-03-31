package boj_4485_녹색옷입은애가젤다지;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static final int INF = Integer.MAX_VALUE;
	static int N;
	static int[][] map;
	static int[][] dist;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	
	static int min;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int tc = 1;
		while(true) {
			N = Integer.parseInt(br.readLine());
			if(N == 0) {
				break;
			}
			sb.append("Problem ").append(tc++).append(": ");
			
			
			map = new int[N][N];
			dist = new int[N][N];
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(i != 0 && j != 0) {
						dist[i][j] = INF;
					}
				}
			}
			min = Integer.MAX_VALUE;
			dijkstra(0,0);
			sb.append(min).append("\n");
		}
		System.out.println(sb);
	}
	
	static void dijkstra(int x, int y) {
		if(x == N-1 && y == N-1) {
			min = Math.min(dist[y][x], min);
			return;
		}
		
		for(int i =0; i<4; i++) {
			int xx = x + dx[i];
			int yy = y + dy[i];
			
			if(bound(xx, yy) && dist[yy][xx] > dist[y][x] + map[y][x]) {
				dist[yy][xx] = dist[y][x] + map[y][x];
				dijkstra(xx, yy);
			}
		}
	}
	static boolean bound(int x, int y) {
		return x>=0&&y>=0&&x<N&&y<N;
	}
}
