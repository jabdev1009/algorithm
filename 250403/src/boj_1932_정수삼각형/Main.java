package boj_1932_정수삼각형;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int n = Integer.parseInt(br.readLine());
		int max = Integer.MIN_VALUE;
		int[][] dp = new int[n][n];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<=i; j++) {
				dp[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(dp[i][j], max);
				if(i > 0) {
					if(j == 0) {
						dp[i][j] += dp[i-1][j];
					} else {
						dp[i][j] += Math.max(dp[i-1][j], dp[i-1][j-1]);
						max = Math.max(dp[i][j], max);
					}
				}
			}
		}
		System.out.println(max);
	}
}
