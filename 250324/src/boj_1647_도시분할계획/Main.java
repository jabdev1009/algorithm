package boj_1647_도시분할계획;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Edge implements Comparable<Edge>{
		int to;
		int cost;
		public Edge(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}
		@Override
		public String toString() {
			return "Edge [to=" + to + ", cost=" + cost + "]";
		}

		@Override
		public int compareTo(Edge o) {
			return this.cost-o.cost;
		}
	}
	
	static int N;
	static int M;
	
	static ArrayList<Edge>[] graph;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[N+1];
		visited = new boolean[N+1];
		for(int i=0; i<=N; i++) {
			graph[i] = new ArrayList<Edge>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			graph[node1].add(new Edge(node2, cost));
			graph[node2].add(new Edge(node1, cost));
		}
		
		prim(1);
	}
	
	static void prim(int start) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(start, 0));
		int total = 0;
		while(!pq.isEmpty()) {
			Edge edge = pq.poll();
			int to = edge.to;
			int cost = edge.cost;
			if(visited[to]) {
				continue;
			}
			visited[to] = true;
			total += cost;
			for(Edge e : graph[to]) {
				if(!visited[e.to]) {
					pq.add(e);
				}
			}
		}
		System.out.println(total);
	}
}
