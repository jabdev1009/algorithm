package boj_17204_죽음의게임;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int K;
	static int[] point;
	static boolean[] visited;
	static int result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		point = new int[N];
		visited = new boolean[N];
		
		for(int i=0; i<N; i++) {
			point[i] = Integer.parseInt(br.readLine());
		}
		result = -1;
		bfs();
		System.out.println(result);
		
	}
	
	static void bfs() {
		Queue<Integer> q = new ArrayDeque<>();
		q.add(0);
		visited[0] = true;
		int count = 0;
		while(!q.isEmpty()) {
			count++;
			int num = q.poll();
			int next = point[num];
			if(next == K) {
				result = count;
				return;
			} else {
				if(!visited[next]) {
					visited[next] = true;
					q.add(next);
				}
			}
		}
	}
}
