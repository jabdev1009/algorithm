package swea;

import java.util.Scanner;

public class Swea_5432_쇠막대기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T =  sc.nextInt();
		for(int test_case=1; test_case<=T; test_case++) {
			String str = sc.next();
			// 쇠막대 수
			int depth = 0;
			// 조각 계산용 변수
			int count = 0;
			// 가장 최근에 꺼낸 문자를 기록해 두기 위한 변수
			char last = ' ';
			for(int i=0; i<str.length(); i++) {
				// 여는괄호이면 쇠막대 +1
				if(str.charAt(i) == '(') {
					last = '(';
					depth++;
				} else if(str.charAt(i) == ')') {
					// 닫는 괄호이면 쇠막대 -1
					depth--;
					// 이전에 꺼낸 문자가 여는 괄호이면 레이저
					// 쇠막대 개수만큼 더해줌
					if(last == '(') {
						count += depth;
					} else if(last == ')') {
						// 이전에 꺼낸 문자가 닫는 괄호이면 쇠막대 1개 끝
						// 1조각 추가
						count++;
					}
					last = ')';
				}
			}
			System.out.println("#"+test_case+" "+count);
		}
	}
}
