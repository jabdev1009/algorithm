package a_화분;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	// 이전 비료를 표시 하기 위한 상수
	static final int A = 1;
	static final int B = 2;
	// 탐색 시 관리해야할 정보들(화분순서, 이전비료, 현재누적크기기)
	static class Info {
		int pot;
		int before;
		int size;
		public Info(int pot, int before, int size) {
			super();
			this.pot = pot;
			this.before = before;
			this.size = size;
		}
		@Override
		public String toString() {
			return "Info [pot=" + pot + ", before=" + before + ", size=" + size + "]";
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			// 화분 수
			int N = sc.nextInt();
			// 동일비료 연속 시 성장 감소량
			int P = sc.nextInt();
			int[] a = new int[N];
			int[] b = new int[N];
			// A 비료 사용시 기대 성장
			for(int i=0; i<N; i++) {
				a[i] = sc.nextInt();
			}
			// B 비료 사용시 기대 성장
			for(int i=0; i<N; i++) {
				b[i] = sc.nextInt();
			}
			
			// BFS를 할것임 특정화분에서 누적합이 같은 경우가 있을 때 이전 화분 정보가 다르면 다른 결과가 나올 수 있기 때문에 
			// 방문처리나, 중복처리는 일단 안하는 것으로 생각
			Queue<Info> queue = new LinkedList<>();
			// 1번화분 시작
			queue.offer(new Info(1,0,0));
			
			int maxSum = 0;
			
			while(!queue.isEmpty()) {
				Info i = queue.poll();
				int pot = i.pot;
				int before = i.before;
				int size = i.size;
				
				// 현재 화분 순서에 해당하는 각 비료의 성장 크기
				int sizeA = a[pot-1];
				int sizeB = b[pot-1];
				
				// 이전에 사용한 비료가 있다면 동일한 비료에 P만큼 크기를 줄여줌
				if(before == A) {
					sizeA -= P;
				} else if(before == B) {
					sizeB -= P;
				}
				// 비료를 사용했을 때 성장할 크기에 지금까지 누적 크기를 더해줌
				sizeA += size;
				sizeB += size;
				
				// 다음 화분의 번호를 따주고
				int nextPot = ++pot;
				// 다음 화분이 없는 화분이면
				if(nextPot == N+1) {
					// 마지막 비료로 A,B 썼을때 큰것 중에 지금까지의 최대값과 비교해서 초기화화
					int fin = sizeA > sizeB ? sizeA : sizeB; // -> 굳이 안해주고 sizeA, sizeB에 대해 최대값 여부 확인했어도 될듯 함
					if(fin > maxSum) {
						maxSum = fin;
					}
				} else {
					// 다음 화분이 있는 화분이면 지금까지의 정보를 담아서 큐에 넣어줌줌
					queue.offer(new Info(nextPot, A, sizeA));
					queue.offer(new Info(nextPot, B, sizeB));
				}	
					
			}
			// 결과를 출력하자
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ").append(maxSum);
			System.out.println(sb);
		}
	}
}
