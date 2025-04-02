package boj_2665_미로만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static final int INF = Integer.MAX_VALUE;
	static int n;
	static int[][] map;
	static int[][] dist;
	static boolean[][] visited;
	static PriorityQueue<int[]> pq;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		n = Integer.parseInt(br.readLine());
		
		map = new int[n][n];
		dist = new int[n][n];
		visited = new boolean[n][n];
		
		for(int i=0; i<n; i++) {
			String[] arr = br.readLine().split("");
			for(int j=0; j<n; j++) {
				map[i][j] = 1^Integer.parseInt(arr[j]);
				if(i != 0 || j != 0) {
					dist[i][j] = INF;
				}
			}
		}
		
		pq = new PriorityQueue<>((a,b) -> a[2]-b[2]);
		pq.add(new int[] {0,0,map[0][0]});
		while(!pq.isEmpty()) {
			int[] info = pq.poll();
			int x = info[0];
			int y = info[1];
			int cost = info[2];
			if(visited[y][x]) {
				continue;
			}
			visited[y][x] = true;
			for(int i=0; i<4; i++) {
				int xx = x + dx[i];
				int yy = y + dy[i];
				if(bound(xx, yy) && dist[yy][xx] > cost + map[yy][xx]) {
					dist[yy][xx] = cost + map[yy][xx];
					pq.add(new int[] {xx, yy, dist[yy][xx]});
				}
			}
		}
		System.out.println(dist[n-1][n-1]);
	}
	
	static boolean bound(int xx, int yy) {
		return xx>=0&&yy>=0&&xx<n&&yy<n;
	}
}
