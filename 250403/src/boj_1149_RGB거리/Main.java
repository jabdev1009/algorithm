package boj_1149_RGB거리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[][] info;
//	static int[][] dp;
	
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		
		info = new int[N][3];
//		dp = new int[N][3];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
//			info[i][0] = Integer.parseInt(st.nextToken());
//			info[i][1] = Integer.parseInt(st.nextToken());
//			info[i][2] = Integer.parseInt(st.nextToken());
//			
//			if(i == 0) {
//				dp[i][0] = info[i][0]; 
//				dp[i][1] = info[i][1]; 
//				dp[i][2] = info[i][2]; 
//			} else {
//				dp[i][0] = info[i][0] + Math.min(dp[i-1][1], dp[i-1][2]); 
//				dp[i][1] = info[i][1] + Math.min(dp[i-1][0], dp[i-1][2]); 
//				dp[i][2] = info[i][2] + Math.min(dp[i-1][1], dp[i-1][0]);
//			}
			
			int one = Integer.parseInt(st.nextToken());
			int two = Integer.parseInt(st.nextToken());
			int three = Integer.parseInt(st.nextToken());
			if(i == 0) {
				info[i][0] = one;
				info[i][1] = two;
				info[i][2] = three;
			} else {
				info[i][0] = one + Math.min(info[i-1][1], info[i-1][2]);
				info[i][1] = two + Math.min(info[i-1][0], info[i-1][2]);
				info[i][2] = three + Math.min(info[i-1][1], info[i-1][0]);
			}
		}
//		System.out.println(Math.min(dp[N-1][0], Math.min(dp[N-1][1], dp[N-1][2])));
		System.out.println(Math.min(info[N-1][0], Math.min(info[N-1][1], info[N-1][2])));
		
	}
}
