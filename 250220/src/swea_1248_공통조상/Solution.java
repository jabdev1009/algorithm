package swea_1248_공통조상;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	static int[][] tree;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc = 1;  tc<=T; tc++) {
			int v = sc.nextInt();
			int e = sc.nextInt();
			int node1 = sc.nextInt();
			int node2 = sc.nextInt();
			
			// 입력받은 크기의 트리를 만들고
			// 각 노드는 좌, 우, 부모 정보를 가지고 있다
			tree = new int[v+1][3];
			for(int i=0; i<e; i++) {
				// 연결된 노드 정보를 받아서
				int tNode = sc.nextInt();
				int fNode = sc.nextInt();
				// 부모노드 좌, 우측 순서로 빈 곳이 있으면 넣어준다
				if(tree[tNode][0] == 0) {
					tree[tNode][0] = fNode;
				} else {
					tree[tNode][1] = fNode;
				}
				// 자식노드인 경우 부모 노드 정보를 넣어준다.
				tree[fNode][2] = tNode;
			}
			// 가장 가까운 공통 조상을 찾기 위해 각 노드들의 부모 리스트를 받아온다.
			List<Integer> list1 = getPList(node1);
			List<Integer> list2 = getPList(node2);
			// 각 리스트에서 공통된 노드만 남긴다.
			list1.retainAll(list2);
			// 공통된 노드 중 가장 가까운 노드 == 인덱스0
			int common = list1.get(0);
			// 찾아낸 공통조상의 서브트리크기를 구해서
			int size = getSize(common);
			// 찍어준다
			System.out.println("#"+tc+" "+common+" "+size);
			
		}
	}
	// 입력받은 번호에 해당하는 노드의 부모정보를 타고타고 가다가 루트만나면 끝
	static List<Integer> getPList(int node) {
		List<Integer> list = new ArrayList<>();
		int p = node;
		// 조건 검사 값을 부모노드의 번호로 초기화 해주면서 루트를 만나면 반복문 종료 
		while(p != 1) {
			// 노드의 부모정보를 꺼내와서
			p = tree[p][2];
			// 리스트에 담아준다.
			list.add(p); 
		}
		return list;
	}
	static int getSize(int node) {
		int count = 1;
		// 노드의 자식노드들을 큐에 담고 자식이 있으면 다시 큐에넣고...
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(node);
		// 큐 빌 때까지
		while(!queue.isEmpty()) {
			int n = queue.poll();
			
			// 좌, 우측 자식 있니?
			for(int i=0; i<2; i++) {
				int tmp = tree[n][i];
				// 있으면
				if(tmp != 0) {
					// 갯수 올려주고 
					count++;
					// 큐에 넣어
					queue.offer(tmp);
				}
			}
		}
		return count;
	}
}
