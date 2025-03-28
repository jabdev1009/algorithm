package swea_1249_보급로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
	
	static class Node implements Comparable<Node> {
		int x, y, cost;

		public Node(int x, int y, int cost) {
			this.x = x;
			this.y = y;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return this.cost-o.cost;
		}
	}
	
	static int N;
	static int[][] map;
	static int[][] dist;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	
	static int ans;
	
	static PriorityQueue<Node> pq;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++, sb.append("\n")) {
			sb.append('#').append(tc).append(' ');
			
			N = Integer.parseInt(br.readLine());
			
			map = new int[N][N];
			dist = new int[N][N];
			ans = Integer.MAX_VALUE;
			for(int i=0; i<N; i++) {
				String[] arr = br.readLine().split("");
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(arr[j]);
					dist[i][j] = Integer.MAX_VALUE;
				}
			}
			
			pq = new PriorityQueue<>();
			pq.offer(new Node(0,0,0));
			
			while(!pq.isEmpty()) {
				Node node = pq.poll();
				if(node.x + node.y == 2*(N-1)) {
					ans = Math.min(node.cost, ans);
					continue;
				}
				for(int i=0; i<4; i++) {
					int xx = node.x + dx[i];
					int yy = node.y + dy[i];
					if(bound(xx, yy) && (dist[yy][xx] > map[yy][xx] + node.cost)) {
						dist[yy][xx] = map[yy][xx] + node.cost;
						pq.offer(new Node(xx, yy, dist[yy][xx]));
					}
				}
			}
			sb.append(ans);
		}
		System.out.println(sb);
	}
	static boolean bound(int x, int y) {
		return x>=0&&y>=0&&x<N&&y<N;
	}
}