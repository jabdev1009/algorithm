package swea_1267_작업순서_Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int V,E;
	static List<Integer>[] adj;
	static Queue<Integer> q;
	static int[] degree;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int T = 10;
		for (int tc = 1; tc <= T; tc++, sb.append("\n")) {
			sb.append('#').append(tc).append(' ');
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			adj = new ArrayList[V+1];
			degree = new int[V+1];
			for(int i=1; i<=V; i++) {
				adj[i] = new ArrayList<>();
			}
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<E; i++) {
				int s = Integer.parseInt(st.nextToken()); 
				int e = Integer.parseInt(st.nextToken());
				
				adj[s].add(e);
				degree[e]++;
			}
			
			q = new LinkedList<>();
			for(int i=1; i<=V; i++) {
				if(degree[i] == 0) {
					q.add(i);
				}
			}
			while(!q.isEmpty()) {
				int curr = q.poll();
				sb.append(curr).append(' ');
				
				for(int to : adj[curr]) {
					if(--degree[to] == 0) {
						q.add(to);
					}
				}
			}
		}
		System.out.println(sb);
	}
}
