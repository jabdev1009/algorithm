package boj_1647_도시분할계획;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		List<int[]>[] graph = new ArrayList[N+1];
		
		for(int i=1; i<=N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1]-o2[1];
			}
		});
		
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			
			graph[s].add(new int[] {e, p});
			graph[e].add(new int[] {s, p});
		}
		
		boolean[] visited = new boolean[N+1];
		pq.addAll(graph[1]);
		visited[1] = true;
		int sum = 0;
		int maxP = 0;
		while(!pq.isEmpty()) {
			int[] info = pq.poll();
			int node = info[0];
			int price = info[1];
			
			if(!visited[node]) {
				visited[node] = true;
				maxP = Math.max(maxP, price);
				sum += price;
				pq.addAll(graph[node]);
			}
		}
		System.out.println(sum-maxP);
	}
}
