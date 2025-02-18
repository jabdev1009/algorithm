package swea_1228_암호문;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
	static ArrayList<String> codes;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;
		for(int tc=1; tc<=T; tc++) {
			int n = sc.nextInt();
			
			// 암호문 한 덩어리를 String으로 받아 줌
			codes = new ArrayList<String>();
			for(int i=0; i<n; i++) {
				codes.add(sc.next());
			}
			// 명령어 개수
			int command = sc.nextInt();
			
			for(int i=0; i<command; i++) {
				sc.next(); // 명령어 시작을 알리는 부분은 버리고
				int place = sc.nextInt(); // 어디부터
				int len = sc.nextInt(); // 몇개의 암호문을 삽입할지
				// 어디부터에 해당하는 인덱스에 1증가 시키면서 삽입 시킬 암호문을 입력받아 채워주고
				for(int j=place; j<place+len; j++) {
					codes.add(j, sc.next());
				}
			}
			// 10개만 출력
			System.out.print("#" + tc+ " ");
			for(int i=0; i<10; i++) {
				System.out.print(codes.get(i) + " ");
			}
			System.out.println();
		}
	}
}
