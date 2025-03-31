package swea_1263_사람네트워크2;

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
	
	static int N, min, count;
	
	static List<Integer>[] graph;
	static boolean[] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++, sb.append("\n")) {
			sb.append('#').append(tc).append(' ');
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			graph = new ArrayList[N+1];
			for(int i=1; i<=N; i++) {
				graph[i] = new ArrayList<>();
			}
			
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					int n = Integer.parseInt(st.nextToken());
					if(n == 1) {
						graph[i].add(j);
					}
				}
			}
			min = Integer.MAX_VALUE;
			for(int i=1; i<=N; i++) {
				bfs(i);
			}
			sb.append(min);
		}
		System.out.println(sb);
	}
	static void bfs(int start) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {start, 0});
		count = 0;
		visited = new boolean[N+1];
		visited[start] = true;
		while(!q.isEmpty()) {
			int[] info = q.poll();
			int node = info[0];
			int len = info[1];
			for(int i : graph[node]) {
				if(!visited[i]) {
					visited[i] = true;
					q.add(new int[] {i, len+1});
					count += (len+1);
				}
			}
		}
		min = Math.min(min, count);
	}
}
