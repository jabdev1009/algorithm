package boj_1197_최소_스패닝_트리;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {
	static class Edge implements Comparable<Edge>{
		int node;
		int cost;
		public Edge(int node, int cost) {
			this.node = node;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Edge o) {
			return this.cost-o.cost;
		}
	}
	
	static int V;
	static int E;
	
	static ArrayList<Edge>[] graph;
	static PriorityQueue<Edge> pq;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[V+1];
		visited = new boolean[V+1];
		for(int i=0; i<=V; i++) {
			graph[i] = new ArrayList<>();
		}
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			graph[node1].add(new Edge(node2,cost));
			graph[node2].add(new Edge(node1,cost));
		}
		
		prim(1);
		
	}
	static void prim(int start) {
		pq = new PriorityQueue<Edge>();
		pq.add(new Edge(start,  0));
		
		int total = 0;
		while(!pq.isEmpty()) {
			Edge edge =  pq.poll();
			int node2 = edge.node;
			int cost = edge.cost;
			if(visited[node2]) {
				continue;
			}
			visited[node2] = true;
			total += cost;
			for(Edge e : graph[node2]) {
				if(!visited[e.node]) {
					pq.add(e);
				}
			}
		}
		System.out.println(total);
	}
}