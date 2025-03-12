package boj_21937_작업;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static ArrayList<ArrayList<Integer>> graph;
	static boolean[] visited;
	static int N;
	static int M;
	static int target;
	static int count;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); 
		M = Integer.parseInt(st.nextToken());
		
		visited = new boolean[N+1];
		graph = new ArrayList<ArrayList<Integer>>();
		for(int i=0; i<N+1; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			
			graph.get(node2).add(node1);
		}
		target = Integer.parseInt(br.readLine());
		count = 0;
		
		bfs(target);
		System.out.println(count);
	}
	static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		visited[start] = true;
		queue.offer(start);
		
		while(!queue.isEmpty()) {
			int node = queue.poll();
			
			if(graph.get(node).size() != 0) {
				for(int i=0; i<graph.get(node).size(); i++) {
					
					int next = graph.get(node).get(i);
					if(!visited[next]) {
						count++;
						visited[next] = true;
						queue.offer(next);
					}
				}
			}
		}
	}
}
