package boj_18352_특정거리의도시찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken()); // 도시 개수
		int m = Integer.parseInt(st.nextToken()); // 도로 개수
		int k = Integer.parseInt(st.nextToken()); // 거리 정보
		int x = Integer.parseInt(st.nextToken()); // 출발 도시 번호

		// 그래프 초기화
		ArrayList<Integer>[] graph = new ArrayList[n + 1];
		for (int i = 0; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}

		// 간선 입력
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			graph[from].add(to); // 단방향 도로
		}

		// 다익스트라 수행
		int[] dist = new int[n + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dijkstra(x, graph, dist);

		// 결과 출력
		boolean found = false;
		for (int i = 1; i <= n; i++) {
			if (dist[i] == k) {
				System.out.println(i);
				found = true;
			}
		}
		if (!found) System.out.println(-1);
	}

	static void dijkstra(int start, ArrayList<Integer>[] graph, int[] dist) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));
		dist[start] = 0;

		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			int now = cur.index;
			int cost = cur.cost;

			if (dist[now] < cost) continue;

			for (int next : graph[now]) {
				if (dist[next] > cost + 1) {
					dist[next] = cost + 1;
					pq.offer(new Node(next, dist[next]));
				}
			}
		}
	}

	static class Node implements Comparable<Node> {
		int index;
		int cost;

		public Node(int index, int cost) {
			this.index = index;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}
}
