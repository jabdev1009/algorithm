package boj_13023_ABCDE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int M;
	static ArrayList<ArrayList<Integer>> graph;
	static boolean[] visited;
	static int depth;
	static int target;
	static boolean isAns;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		depth = 1;
		target = 5;
		isAns = false;
		graph = new ArrayList<ArrayList<Integer>>();
		visited = new boolean[N];
		for(int i=0; i<N; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			
			graph.get(node1).add(node2);
			graph.get(node2).add(node1);
		}
		
		for(int i=0; i<N; i++) {
			dfs(i, 1);
			visited = new boolean[N];
		}
		System.out.println(isAns?1:0);
		
	}
	
	static void dfs(int start, int depth) {
		if(isAns) {
			return;
		}
		if(depth == target) {
			isAns = true;
			return;
		}
		
		visited[start] = true;
		for(int i=0; i<graph.get(start).size(); i++) {
			int node = graph.get(start).get(i);
			if(!visited[node]) {
				visited[node] = true;
				dfs(node, depth+1);
				visited[node] = false;
			}
		}
	}
}
