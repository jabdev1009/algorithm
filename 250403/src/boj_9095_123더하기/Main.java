package boj_9095_123더하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int[] dp;
	static {
		dp = new int[12];
		setDp(11);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			System.out.println(dp[Integer.parseInt(br.readLine())]);
		}
	}
	
	static int setDp(int n) {
		if(n<=2) {
			dp[n] = n;
			return dp[n];
		}
		if(n == 3) {
			dp[n] = 4;
			return dp[n];
		}
		return dp[n] = setDp(n-3) + setDp(n-2) + setDp(n-1); 
	}
}
