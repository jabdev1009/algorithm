package swea_4012_요리사;

import java.util.Scanner;

public class Solution {
	static int n;
	static int r;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			n = sc.nextInt();
			r = n/2;
			int[][] map = new int[n][n];
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			// n개에서 n/2개의 재료를 골라서 담아둔다
			// 담아둔 재료들 중에서 크기 2의 조합을 만들고
			// 조합에 들어있는 재료 각각을 인덱스로 가지는 값, 인덱스를 역으로 넣어준 값의 합
			// z
			
			int[] sel = new int[r];
			
			
		}
	}
}
