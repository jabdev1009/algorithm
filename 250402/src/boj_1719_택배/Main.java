package boj_1719_택배;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static final int INF = Integer.MAX_VALUE;
	static int n, m;
	static List<int[]>[] adj;
	static int[][] dist, log;
	static PriorityQueue<int[]> pq;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		log = new int[n+1][n+1];
		dist = new int[n+1][n+1];
		adj = new ArrayList[n+1];
		for(int i=0; i<=n; i++) {
			adj[i] = new ArrayList<>();
		}
		pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			adj[s].add(new int[] {e, cost});
			adj[e].add(new int[] {s, cost});
		}
		
		for(int i=1; i<=n; i++) {
			dijkstra(i);
		}
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				sb.append(i == j ? "-" : log[i][j]).append(' ');
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
	static void dijkstra(int start) {
		for(int i=1; i<=n; i++) {
			dist[start][i] = INF;
		}
		dist[start][start] = 0;
		pq.add(new int[] {start, 0, 0});
		while(!pq.isEmpty()) {
			int[] info = pq.poll();
			int node = info[0];
			int cost = info[1];
			int first = info[2];
			if(dist[start][node] < cost) {
				continue;
			}
			
			for(int[] arr : adj[node]) {
				int next = arr[0];
				int nCost = arr[1];
				if(dist[start][next] > nCost + cost) {
					dist[start][next] = nCost + cost;
					int f = first == 0 ? next : first;
					pq.add(new int[] {next, dist[start][next], f});
					log[start][next] = f;
				}
			}
		}
	}
}