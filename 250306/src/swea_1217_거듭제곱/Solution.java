package swea_1217_거듭제곱;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int i=1; i<=10; i++) {
			sc.nextInt();
			int C = sc.nextInt();
			int N = sc.nextInt();
			System.out.println("#"+i+" "+pow(C,N));
		}
	}
	
	static int pow(int C, int N) {
		if(N == 0) {
			return 1;
		}
		
		int result = pow(C, (N/2)) * pow(C,(N/2)); 
		if(N % 2 == 1) {
			result *= C;
		}
		return result;
	} 
}