package swea_1225_암호생성기;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int i=0; i<1; i++) {
			int tc = sc.nextInt();
			
			// 큐에 숫자들을 담아둠
			Queue<Integer> queue = new LinkedList<>();
			for(int j=0; j<8; j++) {
				queue.offer(sc.nextInt());
			}
			// 일단 반복
			loop:
			while(true) {
				// 한싸이클이 1~5만큼 빼는거임
				for(int j=1; j<=5; j++) {
					// 하나 꺼내서
					int n = queue.poll();
					// 싸이클 중에 얼마만큼 빼야하는지~
					int next = n-j;
					// 뺐는데 0보다 작으면
					if(next <= 0) {
						// 0으로 설정해주고
						next = 0;
						// 큐에 넣어주고
						queue.offer(next);
						// 결과출력하러 감
						break loop;
					} else {
						// 빼도 0보다 크면 다시 큐에 넣어줌
						queue.offer(next);
					}
				}
			}
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");
			for(int j=0; j<8; j++) {
				sb.append(queue.poll()).append(" ");
			}
			System.out.println(sb);
		}
	}
}
