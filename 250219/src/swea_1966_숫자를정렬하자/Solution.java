package swea_1966_숫자를정렬하자;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			for(int i=0; i<n; i++) {
				arr[i] = sc.nextInt();
			}
			Arrays.sort(arr);
			
			System.out.println("#"+ tc+" ");
			for(int i=0; i<n; i++) {
				System.out.print(arr[i]+" ");
			}
			System.out.println();
		}
	}
}
