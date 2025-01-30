package swea;

import java.util.Scanner;

public class Swea_1895_백만_장자_프로젝트 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 1; test_case<=T; test_case++) {
			int n = sc.nextInt();
			int[] prices = new int[n];
			
			for(int i=0; i<n; i++) {
				prices[i] = sc.nextInt();
			}
			
			long sum = 0;
			int max = 0;
			for(int i=n-1; i>=0; i--) {
				int now = prices[i];
				if(now > max) {
					max = now;
				} else {
					sum += max - now;
				}
			}
			System.out.println("#"+test_case+" "+sum);
		}
	}
}
