package swea_1267_작업순서_Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {
	static int V, E;
	static List<Integer>[] adj;
	static Stack<Integer> stack;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int T = 10;
		for(int tc = 1; tc <= T; tc++, sb.append("\n")) {
			sb.append('#').append(tc).append(' ');
			st = new StringTokenizer(br.readLine());
			
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			adj = new ArrayList[V+1];
			visited = new boolean[V+1];
			stack = new Stack<>();
			for(int i=1; i<=V; i++) {
				adj[i] = new ArrayList<>();
			}
			
			int[] degree = new int[V+1];
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<E; i++) {
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				
				adj[s].add(e);
				degree[e]++;
			}
			
			for(int i=1; i<=V; i++) {
				if(degree[i] == 0) {
					dfs(i);
				}
			}
			
			while(!stack.isEmpty()) {
				sb.append(stack.pop()).append(' ');
			}
		}
		System.out.println(sb);
	}
	static void dfs(int v) {
		visited[v] = true;
		for(int to : adj[v]) {
			if(!visited[to]) {
				dfs(to);
			}
		}
		stack.add(v);
	}
}
