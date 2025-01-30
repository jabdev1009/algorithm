package swea;

import java.util.Scanner;

public class Swea_1289_원재의_메모리_복구하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test_case = sc.nextInt();
		for(int i=1; i<=test_case; i++) {
			String str = sc.next();
			char now = '0';
			int count = 0;
			for(int j=0; j<str.length(); j++) {
				if(str.charAt(j) != now) {
					count++;
					now = now == '0'? '1': '0';
				}
			}
			System.out.println("#"+i+" "+count);
		}
	}
}
