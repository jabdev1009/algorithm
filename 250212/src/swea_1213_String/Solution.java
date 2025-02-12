package swea_1213_String;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;
		for(int tc=1; tc<=10; tc++) {
			// test_case
			int n = sc.nextInt();
			// 찾을거
			String target = sc.next();
			// 여기서
			String str = sc.next();
			
			int count = 0;
			// 여기서 찾을거 위치가 있으면 계속 반복
			while(str.indexOf(target) > -1) {
				// 여기서의 범위를 줄임
				// 찾을거의 위치에 찾을거의 길이를 더한 위치에서 끝까지를 새로운 여기서로 설정
				str = str.substring(str.indexOf(target)+target.length(), str.length());
				// 하나 찾음
				count++;
			}
			System.out.println("#"+n+" "+count);
		}
	}
}
