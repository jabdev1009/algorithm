package swea;

import java.util.Scanner;

public class Swea_2007_패턴_마디의_길이 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case=1; test_case<=T; test_case++) {
			String str = sc.next();
			String pattern = "";
			int length = 0;
			for(int i=0; i<str.length(); i++) {
				pattern += str.charAt(i);
				boolean flag = false;
				for(int j=0; j<str.length(); j++) {
					if(str.charAt(j) == pattern.charAt(j % pattern.length())) {
						flag = true;
					} else {
						flag = false;
						break;
					}
				}
				if(flag) {
					length = i+1;
					break;
				}
			}
			System.out.println("#"+test_case+" " + length);
		}
	}
}
