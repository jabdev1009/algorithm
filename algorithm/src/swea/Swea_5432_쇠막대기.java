package swea;

import java.util.Scanner;

public class Swea_5432_쇠막대기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T =  sc.nextInt();
		for(int test_case=1; test_case<=T; test_case++) {
			String str = sc.next();
			int depth = 0;
			int count = 0;
			char last = ' ';
			for(int i=0; i<str.length(); i++) {
				if(str.charAt(i) == '(') {
					last = '(';
					depth++;
				} else if(str.charAt(i) == ')') {
					depth--;
					if(last == '(') {
						count += depth;
					} else if(last == ')') {
						count++;
					}
					last = ')';
				}
			}
			System.out.println("#"+test_case+" "+count);
		}
	}
}
