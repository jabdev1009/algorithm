package boj_1051_이항계수2;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
//		System.out.println((factorial(n) / factorial(n-k) / factorial(k))%10007);
		System.out.println(combi(n,k)%10007);
		
	}
	static long factorial(int n) {
		long result = 1;
		for(int i=2; i<=n; i++) {
			result *=i;
		}
		return result;
	}
	
	static long combi(int n, int k) {
		// n, k의 크기가 언제일 때 탈출시켜야 하는지
		if() {
			
			
			
		}
		
		
		
		
		
		
		return combi(n-1, k) + combi(n-1, k-1);
	}
}
