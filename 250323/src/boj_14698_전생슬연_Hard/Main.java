package boj_14698_전생슬연_Hard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static final long MOD = 1000000007;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0; i<T; i++) {
			N = Integer.parseInt(br.readLine());
			
			PriorityQueue<Long> pq = new PriorityQueue<>();
			st = new StringTokenizer(br.readLine());
			
			while(st.hasMoreTokens()) {
				pq.add(Long.parseLong(st.nextToken()));
			}
			long cost = 1;
			long multi = 0;
	        while(pq.size() > 1) {
	            multi = pq.poll() * pq.poll();
	            cost = (cost * (multi % MOD)) % MOD;
	 
	            pq.add(multi);
	        }
			
			System.out.println(cost);
		}
		
	}
}
