package swea_의석이;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc<=T; tc++) {
			// 길이를 알 수 없어서 행의 정보로만 초기화
			char[][] arr = new char[5][];
			// 입력된 문자열 중 가장 긴 값
			int max = 0;
			for(int i=0; i<5; i++) {
				// 입력받은 문자를 char[]로 변경, i번째에 넣어줌
				arr[i] = sc.next().toCharArray();
				// 길이 검사
				if(arr[i].length > max) {
					max = arr[i].length;
				}
			}
			
			System.out.print("#"+tc+" ");
			// 가장 긴 문자열 길이만큼 반복
			for(int i=0; i<max; i++) {
				// 5개의 행을 돌면서
				for(int j=0; j<5; j++) {
					// 지금 찍어주려고 하는 행이 찍어 주려는 인덱스 가지고 있니?
					if(arr[j].length > i) {
						// 있으면 찍어줌
						System.out.print(arr[j][i]);
					}
				}
			}
			System.out.println();
		}
	}
}

