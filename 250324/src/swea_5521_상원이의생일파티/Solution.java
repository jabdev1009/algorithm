package swea_5521_상원이의생일파티;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	
	static int N;
	static int M;
	static int[][] graph;
	static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = null;
		int T = sc.nextInt();
		for(int tc = 1; tc<=T; tc++) {
			sb = new StringBuilder();
			sb.append('#').append(tc).append(' ');
			N = sc.nextInt();
			M = sc.nextInt();
			// 친구들 간의 관계를 담아줄 2차원 배열
			graph = new int[N+1][N+1];
			// 초대했는지 여부를 확인하기 위한 배열
			visited = new boolean[N+1];
			// 초기화하고
			for(int i=0; i<M; i++) {
				int node1 = sc.nextInt();
				int node2 = sc.nextInt();
				// 친구관계를 1로 표현함
				graph[node1][node2] = 1;
				graph[node2][node1] = 1;
			}
			
			// 상원이가 몇명 초대 했는지 찾으러감
			invite(1,0);
			
			int count = 0;
			// 상원이를 제외한 친구들 중 초대된 친구의 수를 세어준다.
			for(int i=2; i<=N; i++) {
				if(visited[i]) {
					count++;
				}
			}
			
			sb.append(count);
			System.out.println(sb);
		}
	}
	static void invite(int num, int depth) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {num, depth});
		// 큐가 빌 때까지
		while(!q.isEmpty()) {
			// 지금 친구를 확인하려는 친구와 상원이와의 거리(1 = 상원이와 친한친구, 2 = 상원이와 친한 친구의 친한친구)
			int[] arr = q.poll();
			// 지금 확인 중인 친구의 친구관계
			int[] nums = graph[arr[0]];
			for(int i=1; i<=N; i++) {
				int domodachi = nums[i];
				// 친구이고, 아직 초대 되지 않았고, 상원이와의 거리가 2보다 작을 때
				if(domodachi == 1 && !visited[i] && arr[1]<2) {
					// 그 친구 초대하고
					visited[i] = true;
					// 큐에 초대한 친구와, 상원이와의 거리를 큐에 넣어준다
					q.add(new int[] {i, arr[1]+1});
				}
			}
		}
	}
}
