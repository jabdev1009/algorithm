package jungol;

import java.util.Scanner;

public class Jo_1037_오류교정 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] arr = new int[n][n];
		int[][] sumInfo = new int[2][n];
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		// {{1행합,2행합,3행합,4행합},{1열합,2열합,3열합,4열합}}
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				sumInfo[0][i] += arr[i][j];
				sumInfo[1][i] += arr[j][i];
			}
		}
		
		// 패리티 : 각 행열의 합이 짝수
		// 수정가능 : 각 행열의 합이 짝수가 아니면서 모든 원소의 합이 홀수
		// 패리티불가 : 각 행열의 합이 짝수가 아니면서 모든 원소의 합이 짝수
		boolean isParity = true;
		int total = 0;
		int x = 0;
		int y = 0;
		for(int i=0; i<sumInfo[0].length; i++) {
			total += sumInfo[0][i]; // 주어진 수들의 합
			// 행의 합 중 짝수가 아닌경우가 있으면 패리티X, 해당 idx 저장
			if(sumInfo[0][i] % 2 != 0) {  
				x = i;
				isParity = false;
			}
			// 열의 합 중 짝수가 아닌경우가 있으면 패리티X, 해당 idx 저장
			if(sumInfo[1][i] % 2 != 0) {
				y = i;
				isParity = false;
			}
		}
		if(isParity) {
			System.out.println("OK");
		} else if(!isParity && total % 2 == 0) {
			System.out.println("Corrupt");
		} else {
			System.out.println("Change bit ("+(x+1)+","+(y+1)+")");
		}
	}
}
