package a_나무;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb;
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");
			int n = sc.nextInt();
			
			int[] arr = new int[n];
			int max = Integer.MIN_VALUE;
			
			
			for(int i=0; i<n; i++) {
				int num = sc.nextInt();
				arr[i] = num;
				if(num > max) {
					max = num;
				}
			}
			
			int sh = 0;
			int re = 0;
			
			for(int i=0; i<n; i++) {
				int gap = max - arr[i];
				sh += gap/2;
				re += gap%2;
			}
			
			int result = 0;
			
			if(sh > re) {
				result += re*2;
				sh = sh - re;
				
				re = sh % 3;
				sh = sh / 3;
				
				result += sh*4;
				if(re != 0) {
					result += re+1;
				}
				
				
			} else if(sh == re) {
				result += (re * 2);
			} else {
				result += (sh*2);
				result += (re-sh)*2;
				result--;
			}
			sb.append(result);
			System.out.println(sb);
		}
	}
}