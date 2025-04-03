package boj_11726_2xn타일링;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static final int MOD = 10007;
	static int[] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		dp = new int[n+1];
		
		System.out.println(find(n));
	}
	
	static int find(int n) {
		if(n<=2) {
			return dp[n] = n;
		}
		if(dp[n] != 0) {
			return dp[n]%MOD;
		} else {
			return dp[n] = (find(n-1)%MOD + find(n-2)%MOD)%MOD;
		}
	}
}
