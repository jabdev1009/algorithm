package swea_1216_회문2;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10; 
		for(int i=1; i<=T; i++) {
			int tc = sc.nextInt();
			// 버퍼 비워주기
			sc.nextLine();
			char[][] map = new char[100][100];
			// 문자열로 받아서 문자열을 char[]
			for(int j=0; j<100; j++) {
				map[j] = sc.nextLine().toCharArray();
			}
			int len = 0;
			
			
			for(int j=0; j<100; j++) {
				for(int k=0; k<100; k++) {
					// 현재 인덱스 기준 우, 하 방향으로 회문이 있는지 검사
					StringBuilder sb = new StringBuilder();
					// 행고정
					for(int l=0; l<100-k; l++) {
						// 현재 인덱스부터 넣어서
						sb.append(map[j][k+l]);
						// 뒤집은 문자열 따로 관리
						String reverse = sb.reverse().toString();
						// sb.reverse()하게 되면 reverse()를 호출한 StringBuilder가 가지고 있는 문자열이 뒤집어져서 다시 뒤집어 쥼
						sb.reverse();
						// 지금 문자열이랑 뒤집은 친구가 같니
						if(sb.toString().equals(reverse)) {
							// 같으면 길이를 가져와서
							int nowLen = sb.toString().length();
							// 길이비교해서 지금 길이가 더 길면 
							if(nowLen > len) {
								len = nowLen;
							}
						}
					}
					
					
					
					
					sb = new StringBuilder();
					// 열고정, 위와 같습니다.
					for(int l=0; l<100-j; l++) {
						sb.append(map[j+l][k]);
						String reverse = sb.reverse().toString();
						sb.reverse();
						if(sb.toString().equals(reverse)) {
							int nowLen = sb.toString().length();
							if(nowLen > len) {
								len = nowLen;
							}
						}
					}
				}
			}
			System.out.println("#"+tc+" "+len);
		}
	}
}
