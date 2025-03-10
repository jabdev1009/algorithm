package boj_2885_초콜릿식사;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int size = n;
		int count = Integer.bitCount(n);
		
		if(count > 1) {
			size = (Integer.highestOneBit(n)<<1);
		}
		
		int min = Integer.lowestOneBit(n);
			
		int cutCount = 0;
		if(count > 1) {
			while(min < size) {
				cutCount++;
				min<<=1;
			}
		}
		
		System.out.println(size + " " + cutCount);
		
	}
}
