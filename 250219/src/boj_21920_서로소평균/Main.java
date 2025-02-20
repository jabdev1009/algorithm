package boj_21920_서로소평균;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		int x = sc.nextInt();
		
		long sum = 0;
		int count = 0;
		
		for(int i=0; i<n; i++) {
			if(gcd(arr[i], x) == 1) {
				sum += arr[i];
				count++;
			}
		}
		double avg = (double)sum/count;
		System.out.printf("%.9f",avg);
		
		
		
	}
	static int gcd(int a, int b) {
		if(b == 0) {
			return a;
		}
		return gcd(b, a%b);
	}
	
	static int gcd2(int a, int b) {
		return b==0?a:gcd(b, a%b);
	}
}
