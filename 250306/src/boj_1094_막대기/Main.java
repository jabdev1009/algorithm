package boj_1094_막대기;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int len = 64;
		int count = 0;
		while(len>=1) {
			if(n-len >= 0) {
				n -= len;
				count++;
			}
			if(n == 0) {
				break;
			}
			len = len >> 1;
		}
		System.out.println(count);
	}
}
