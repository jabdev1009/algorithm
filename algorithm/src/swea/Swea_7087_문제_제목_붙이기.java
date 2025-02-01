package swea;

import java.util.Scanner;

public class Swea_7087_문제_제목_붙이기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case=1; test_case<=T; test_case++) {
			int n = sc.nextInt();
			String[] arr = new String[n];
			
			for(int i=0; i<n; i++) {
				arr[i] = sc.next();
			}
			
			int len = 0;
			boolean flag = true;
			
			loop:
			for(int i=65; i<=90; i++) {
				for(int j=0; j<n; j++) {
					char c = arr[j].charAt(0);
					if(c == i) {
						len++;
						break;
					} else if(j == n-1 && c != i) {
						break loop;
					}
				}
			}
			System.out.println("#"+test_case+" "+len);
		}
	}
}
