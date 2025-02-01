package swea;

import java.util.Scanner;

public class Swea_2005_파스칼_삼각형 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case=1; test_case<=T; test_case++) {
			int n = sc.nextInt();
			int[][] arr = new int[n][n];
			System.out.println("#"+test_case+" ");
			for(int i=0; i<n; i++) {
				arr[i][0] = 1;
				arr[i][i] = 1;
				
				
				for(int j=1; j<i; j++) {
					arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
				}
				
				
				
				for(int j=0; j<=i; j++) {
					System.out.print(arr[i][j]+" ");
				}
				System.out.println();
			}
		}
	}
}
