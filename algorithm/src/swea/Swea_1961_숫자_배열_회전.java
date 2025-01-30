package swea;

import java.util.Scanner;

public class Swea_1961_숫자_배열_회전 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++) {
			int n = sc.nextInt();
            int[][] arr = new int[n][n];
            for(int i=0; i<n; i++) {
            	for(int j=0; j<n; j++) {
                	arr[i][j] = sc.nextInt();
                }
            }
            System.out.println("#"+test_case);
			for(int i = 0; i<arr.length; i++) {
                for(int j = arr[i].length - 1; j >= 0; j--) {
                    System.out.print(arr[j][i]);
                }
                System.out.print(" ");
                for(int j = arr[i].length - 1 ; j >= 0; j--) {
                    System.out.print(arr[arr.length-1-i][j]);
                }
                System.out.print(" ");
                for(int j = 0; j<arr[i].length; j++) {
                    System.out.print(arr[j][arr.length-1-i]);
                }
                System.out.println("");
            }
		}
	}
}
