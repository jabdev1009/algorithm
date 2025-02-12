package swea_1989_초심자의_회문검사;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 1; test_case<=T; test_case++) {
			// 검사할 문자열
			String str = sc.next();
			// 길이
			int len = str.length();
			// 결과값
			int result = 1;
			for(int i=0; i<len/2; i++) {
				// 문자열에서 인덱스에 있는 캐릭터가 같은지 검사
				if(str.charAt(i) != str.charAt(len-1-i)) {
					result = 0;
				}
			}
			System.out.println("#"+test_case+" "+result);
		}
	}
}
