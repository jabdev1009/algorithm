package boj_5972_택배배송;

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
	static int N,M;
	static int[] dist;
	static List<int[]>[] adj;
	static PriorityQueue<int[]> pq;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		adj = new ArrayList[N+1];
		dist = new int[N+1];
		
		for(int i=0; i<=N; i++) {
			adj[i] = new ArrayList<>();
			dist[i] = INF;
		}
		dist[1] = 0;
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken()); 
			int e = Integer.parseInt(st.nextToken()); 
			int cost = Integer.parseInt(st.nextToken());
			
			adj[s].add(new int[] {e, cost});
			adj[e].add(new int[] {s, cost});
		}
		
		pq = new PriorityQueue<>((a,b) -> a[1]-b[1]);
		
		pq.add(new int[] {1, 0});
		
		while(!pq.isEmpty()) {
			int[] info = pq.poll();
			int node = info[0];
			int cost = info[1];
			if(dist[node] < cost) {
				continue;
			}
			for(int[] arr : adj[node]) {
				int next = arr[0];
				int nCost = arr[1];
				
				if(dist[next] > nCost + cost) {
					dist[next] = nCost + cost;
					pq.add(new int[] {next, dist[next]});
				}
			}
		}
		System.out.println(dist[N]);
	}
}
