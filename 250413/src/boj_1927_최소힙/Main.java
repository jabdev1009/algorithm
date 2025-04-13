package boj_1927_최소힙;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<T; i++) {
			int n = Integer.parseInt(br.readLine());
			
			if(n == 0) {
				if(pq.size() == 0) {
					sb.append(0);
				} else {
					sb.append(pq.poll());
				}
				sb.append('\n');
			} else {
				pq.offer(n);
			}
		}
		System.out.println(sb.toString());
	}
}
