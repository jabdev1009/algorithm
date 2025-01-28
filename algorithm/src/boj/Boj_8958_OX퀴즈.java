package boj;

import java.util.Scanner;

public class Boj_8958_OX퀴즈 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test_case = sc.nextInt();
		
		int score = 1; // 현재 더할 점수
		int sum = 0; // 총점
		// OX 문자열을 입력받아 길이만큼 반복문을 돌면서 
		// O이면 score를 sum에 더하고 1증가
		// X이면 score를 1로 만들고 다음 문자 검사
		for(int i=0; i<test_case; i++) {
			String str = sc.next();
			int len = str.length();
			for(int j=0; j<len; j++) {
				char tmp = str.charAt(j);
				if(tmp == 'O') {
					sum += score++;
				} else {
					score = 1;
				}
			}
			System.out.println(sum);
			sum = 0;
			score = 1;
		}
	}
}
