package swea_5125_햄버거다이어트;

import java.util.Scanner;

public class Solution {
	
	static int n;
	static int L;
	static int[] scores;
	static int[] cals;
	
	static int result;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb;
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			n = sc.nextInt();
			L = sc.nextInt();
			scores = new int[n];
			cals = new int[n];
			result = 0;
			sb = new StringBuilder();
			sb.append('#').append(tc).append(' ');
			
			for(int i=0; i<n; i++) {
				scores[i] = sc.nextInt();
				cals[i] = sc.nextInt();
			}
			
			find(0,0,0);
			sb.append(result);
			
			System.out.println(sb);
		}
	}
	
	static void find(int idx, int cal, int score) {
		if (cal > L) {
			return;	
		}

		result = Math.max(result, score);
		
		for(int i=idx; i<n; i++) {
			find(i+1, cal+cals[i], score+scores[i]);
		}
	}
}
