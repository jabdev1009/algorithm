package swea;

import java.util.Scanner;

public class Swea_4789_성공적인_공연_기획 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case=1; test_case<=T; test_case++) {
			String str = sc.next();
			int count = 0;
			int result = 0;
			for(int i=0; i<str.length(); i++) {
				int now = Character.getNumericValue(str.charAt(i));
				if(now > 0 && i > count) {
					result += i-count;
					count = i;
				}
				count += now;
			}
			System.out.println("#"+test_case+" "+result);
		}
	}
}
