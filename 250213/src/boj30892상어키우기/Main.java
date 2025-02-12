package boj30892상어키우기;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		long t = sc.nextLong();
		
		long[] sharks = new long[n];
		for(int i=0; i<n; i++) {
			sharks[i] = sc.nextLong();
		}
		// 시간초과.. 사이즈 커지면 어케 풀어야할지
		for(int i=0; i<k; i++) {
			Arrays.sort(sharks);
			for(int j=sharks.length-1; j>=0; j--) {
				if(sharks[j] < t) {
					t += sharks[j];
					sharks[j] = 0;
					break;
				}
			}
		}
		System.out.println(t);
		
	}
}
