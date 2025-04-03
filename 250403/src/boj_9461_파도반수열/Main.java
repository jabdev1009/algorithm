package boj_9461_파도반수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static long[] dp;
	static {
		dp = new long[101];
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0; i<T; i++) {
			
			int N = Integer.parseInt(br.readLine());
			find(N);
			
			System.out.println(dp[N]);
		}
	}
	
	static long find(int n) {
		if(n<=3) {
			dp[n] = 1;
			return dp[n];
		}
		if(n <= 5) {
			dp[n] = 2;
			return dp[n];
		}
		if(dp[n] != 0) {
			return dp[n];
		}
		return dp[n] = find(n-5) + find(n-1);
	}
}