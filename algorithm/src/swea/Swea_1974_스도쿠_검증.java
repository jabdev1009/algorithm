package swea;

import java.util.Scanner;

public class Swea_1974_스도쿠_검증 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case=1; test_case<=T; test_case++) {
			int[][] arr = new int[9][9];
			
			for(int i=0; i<9; i++) {
				for(int j=0; j<9; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			int result = 1;
			loop:
			for(int i=0; i<9; i++) {
				int row = 0;
				int col = 0;
				int square = 0;
				for(int j=0; j<9; j++) {
					row += arr[i][j];
					col += arr[j][i];
					
					
					if(i % 3 == 0 && j % 3 == 0) {
						for(int k=0; k<=2; k++) {
							for(int l=0; l<=2; l++) {
								square += arr[i+k][j+l];
							}
						}
						if(square != 45) {
							result = 0;
							break loop;
						}
						square = 0;
					}
				}
				if(row != 45 || col != 45) {
					result = 0;
					break loop;
				}
			}
			
			System.out.println("#"+test_case+" "+result);
		}
	}
}
