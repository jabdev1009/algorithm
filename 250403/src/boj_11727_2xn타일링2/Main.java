package boj_11727_2xn타일링2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static final int MOD = 10007;
	static long[] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		dp = new long[n+1];
		
		dp[1] = 1;
		dp[2] = 3;
		System.out.println(find(n));
	}
	
	static long find(int n) {
		if(n <= 2) {
			return dp[n];
		}
		if(dp[n] != 0) {
			return dp[n];
		}
		return dp[n] = ((find(n-2)*2)%MOD + find(n-1))%MOD;
	}
}
