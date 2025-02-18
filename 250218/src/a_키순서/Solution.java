package a_키순서;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	// 입력되는 정보 중 특정 노드로 들어오는 방향인 것과 특정 노드로 나가는 방향인 것을 
	// 서로 다른 ArrayList에 담아주자
	static ArrayList<ArrayList<Integer>> graphIn;
	static ArrayList<ArrayList<Integer>> graphOut;
	// 노드들은 1차원 배열의 인덱스로 방문처리 하자
	static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			// 학생 수
			int N = sc.nextInt();
			// 키의 크기 정보 수
			int M = sc.nextInt();
			// 정보들을 담아 줄 리스트 2개를 초기화 하자
			// 인덱스로 접근하기 쉽게 +1
			graphIn = new ArrayList<ArrayList<Integer>>();
			graphOut = new ArrayList<ArrayList<Integer>>();
			for(int i=0; i<N+1; i++) {
				graphIn.add(new ArrayList<Integer>());
				graphOut.add(new ArrayList<Integer>());
			}
			// 크기 정보를 넣어줄건데
			for(int i=0; i<M; i++) {
				int node1 = sc.nextInt();
				int node2 = sc.nextInt();
				// node1이 node2보다 작다 == node2가 node1보다 크다
				// 위의 양 변?의 정보를 리스트에 담아줌
				// 그럼 결과적으로 In에는 특정 노드보다 큰 경우 연결정보
				// Out에는 특정 node보다 작은 경우 연결정보가 담기게 됨
				graphIn.get(node1).add(node2);
				graphOut.get(node2).add(node1);
			}
			
			int count = 0;
			// 모든 노드에 대해서
			for(int i=1; i<=N; i++) {
				// 노드가 바뀔 때마다 방문정보를 reset
				visited = new boolean[N+1];
				inChk(i);
				outChk(i);
				// 전체 노드가 방문처리 되었는지 확인하기 위한 변수
				boolean flag = true;
				// 방문처리 안된놈 있으면 내 순서를 알 수 없다는 뜻
				for(int j=1; j<=N; j++) {
					if(!visited[j]) {
						// false이기 때문에 마지막에 count 안해줌
						flag = false;
						break;
					}
				}
				if(flag) {
					count++;
				}
			}
			// 출력해보자
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ").append(count);
			System.out.println(sb);
		}
	}
	// 입력받은 노드에서 나가는 방향에 있는 노드들을 탐색
	static void inChk(int num) {
		//bfs를 위한 queue
		Queue<Integer> queue = new LinkedList<>();
		// 입력된 노드는 방문처리해주고
		visited[num] = true;
		// 큐에 넣어준다
		queue.offer(num);
		// 큐가 빌때 까지 
		while(!queue.isEmpty()) {
			int node = queue.poll();
			ArrayList<Integer> list = graphIn.get(node);
			// 노드 꺼내서 거기서 나가는 방향에 연결된 다른 노드가 있는지
			int size = list.size();
			// 있으면
			if(size > 0) {
				// 있는 만큼 반복, 방문처리하고 
				// 방문처리한 노드에서 나가는 방향으로 연결된 다른 노드가 있나?
				// 큐에 넣어두고 while문 돌면서 다시 확인
				for(int i=0; i<size; i++) {
					int next = list.get(i);
					if(!visited[next]) {
						visited[next] = true;
						queue.offer(next);
					}
				}
			}
		}
	}
	// 위의 메소드와 같고 graphOut 리스트에 대해 노드로 들어오는 방향에 있는 노드들을 탐색
	static void outChk(int num) {
		Queue<Integer> queue = new LinkedList<>();
		visited[num] = true;
		queue.offer(num);
		
		while(!queue.isEmpty()) {
			int node = queue.poll();
			ArrayList<Integer> list = graphOut.get(node);
			int size = list.size();
			if(size > 0) {
				for(int i=0; i<size; i++) {
					int next = list.get(i);
					if(!visited[next]) {
						visited[next] = true;
						queue.offer(next);
					}
				}
			}
		}
	}
}
