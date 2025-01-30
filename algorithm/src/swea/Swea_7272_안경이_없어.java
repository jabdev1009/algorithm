package swea;

import java.util.Scanner;

public class Swea_7272_안경이_없어 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case=1; test_case<=T; test_case++) {
			String str1 = sc.next();
			String str2 = sc.next();
			String result = "SAME";
			if(str1.length() != str2.length()) {
				result = "DIFF";
			} else {
				for(int i=0; i<str1.length(); i++) {
					char s1 = str1.charAt(i);
					char s2 = str2.charAt(i);
					if(chkHoles(s1) != chkHoles(s2)) {
						result = "DIFF";
						break;
					}
				}
			}
			System.out.println("#"+test_case+" "+result);
			
		}
	}
	public static int chkHoles(char c) {
		String h1 = "ADOPQR";
		int result = 0;
		
		if(h1.contains(c+"")) {
			result = 1;
		} else if(c == 'B') {
			result = 2;
		}
		return result;
	}
}
