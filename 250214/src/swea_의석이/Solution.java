package swea_의석이;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc<=T; tc++) {
			char[][] arr = new char[5][];
			int max = 0;
			for(int i=0; i<5; i++) {
				arr[i] = sc.next().toCharArray();
				if(arr[i].length > max) {
					max = arr[i].length;
				}
			}
			
			System.out.print("#"+tc+" ");
			for(int i=0; i<max; i++) {
				for(int j=0; j<5; j++) {
					if(arr[j].length > i) {
						System.out.print(arr[j][i]);
					}
				}
			}
			System.out.println();
		}
	}
}

