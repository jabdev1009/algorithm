package boj_1916_최소비용구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static int start, end;
	
	static PriorityQueue<int[]> pq;
	static int[] dist;
	static List<int[]>[] adj;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		adj = new ArrayList[N+1];
		dist = new int[N+1];
		for(int i=0; i<=N; i++) {
			adj[i] = new ArrayList<>();
			dist[i] = Integer.MAX_VALUE;
		}
		pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			adj[s].add(new int[] {e, cost});
		}
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		dist[start] = 0;
		end = Integer.parseInt(st.nextToken()); 
		if(start == end) {
			System.out.println(0);
			return;
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
		System.out.println(dist[end]);
	}
}	
