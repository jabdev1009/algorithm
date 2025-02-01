package swea;

import java.util.Scanner;

public class Swea_11315_오목_판정 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case=1; test_case<=T; test_case++) {
			int n = sc.nextInt();
			char[][] arr = new char[n][n];
			for(int i=0; i<n; i++) {
				String str = sc.next();
				for(int j=0; j<n; j++) {
					arr[i][j] = str.charAt(j);
				}
			}
			
			String result = "NO";
			loop:
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					// 현재 idx에서 가로로 오목 검증
					if(n-j >= 5) {
						for(int k=0; k<5; k++) {
							if(arr[i][j+k] != 'o') {
								break;
							} else if(arr[i][j+k] == 'o' && k == 4) {
								result = "YES";
								break loop;
							}
						}
					}
					// 현재 idx에서 세로로 오목 검증
					if(n-i >= 5) {
						for(int k=0; k<5; k++) {
							if(arr[i+k][j] != 'o') {
								break;
							} else if(arr[i+k][j] == 'o' && k == 4) {
								result = "YES";
								break loop;
							}
						}
					}
					// 현재 idx에서 대각(우하)으로 오목 검증
					if(n-j >= 5 && n-i >= 5) {
						for(int k=0; k<5; k++) {
							if(arr[i+k][j+k] != 'o') {
								break;
							} else if(arr[i+k][j+k] == 'o' && k == 4) {
								result = "YES";
								break loop;
							}
						}
					}
					// 현재 idx에서 대각(우상)으로 오목 검증
					if(n-j >= 5 && i >= 4) {
						for(int k=0; k<5; k++) {
							if(arr[i-k][j+k] != 'o') {
								break;
							} else if(arr[i-k][j+k] == 'o' && k == 4) {
								result = "YES";
								break loop;
							}
						}
					}
				}
			}
			System.out.println("#"+test_case+" "+result);
		}
	}
}
