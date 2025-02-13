package boj30892상어키우기;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		long t = sc.nextLong();
		
//		long[] sharks = new long[n];
//		for(int i=0; i<n; i++) {
//			sharks[i] = sc.nextLong();
//		}
//		// 시간초과.. 사이즈 커지면 어케 풀어야할지
//		Arrays.sort(sharks);
//		int idx = 0;
//		for(int i=0; i<k; i++) {
//			for(int j=idx; j<n; j++) {
//				// 먹을 수 있는 상어 중 가장 큰 상어의 idx값을 저장
//				
//			}
//		}
//		System.out.println(t);
		
		Queue<Integer> pq = new PriorityQueue<>();
		for(int i=0; i<n; i++) {
			pq.offer(sc.nextInt());
		}
		
		Stack<Integer> s = new Stack<>();
		while(k>0) {
			while(!pq.isEmpty() && pq.peek() < t) {
				s.push(pq.poll());
			}
			
			if(!s.isEmpty()) {
				t += s.pop();
			} else {
				break;
			}
			k--;
		}
		System.out.println(t);
	}
}
