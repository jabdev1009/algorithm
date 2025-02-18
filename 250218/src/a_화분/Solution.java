package a_화분;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	static final int A = 1;
	static final int B = 2;
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
			int N = sc.nextInt();
			int P = sc.nextInt();
			int[] a = new int[N];
			int[] b = new int[N];
			
			for(int i=0; i<N; i++) {
				a[i] = sc.nextInt();
			}
			for(int i=0; i<N; i++) {
				b[i] = sc.nextInt();
			}
			
			Queue<Info> queue = new LinkedList<>();
			queue.offer(new Info(1,0,0));
			
			int maxSum = 0;
			
			while(!queue.isEmpty()) {
				Info i = queue.poll();
				int pot = i.pot;
				int before = i.before;
				int size = i.size;
				
				int sizeA = a[pot-1];
				int sizeB = b[pot-1];
				
				if(before == A) {
					sizeA -= P;
				} else if(before == B) {
					sizeB -= P;
				}
				sizeA += size;
				sizeB += size;
				int nextPot = ++pot;
				if(nextPot == N+1) {
					int fin = sizeA > sizeB ? sizeA : sizeB;
					if(fin > maxSum) {
						maxSum = fin;
					}
				} else {
					queue.offer(new Info(nextPot, A, sizeA));
					queue.offer(new Info(nextPot, B, sizeB));
				}	
					
			}
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ").append(maxSum);
			System.out.println(sb);
		}
	}
}
