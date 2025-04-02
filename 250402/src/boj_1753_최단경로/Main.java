package boj_1753_최단경로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static final int INF = Integer.MAX_VALUE;
	static int V, E;
	static int start;
	
	static PriorityQueue<int[]> pq;
	static int[] dist;
	static List<int[]>[] adj;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		adj = new ArrayList[V+1];
		dist = new int[V+1];
		for(int i=0; i<=V; i++) {
			adj[i] = new ArrayList<>();
			dist[i] = INF;
		}
		pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
		start = Integer.parseInt(br.readLine());
		dist[start] = 0;
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			adj[s].add(new int[] {e, cost});
		}
		pq.add(new int[] {start, 0});
		while(!pq.isEmpty()) {
			int[] info = pq.poll();
			int node = info[0];
			int cost = info[1];
			if(dist[node] < cost) {
				continue;
			}
			for(int[] arr : adj[node]) {
				if(dist[arr[0]] > cost + arr[1]) {
					dist[arr[0]] = cost + arr[1];
					pq.add(new int[] {arr[0], dist[arr[0]]});
				}
			}
		}
		for(int i=1; i<=V; i++) {
			sb.append(dist[i] == INF ? "INF" : dist[i]).append("\n");
		}
		System.out.println(sb);
	}
}	