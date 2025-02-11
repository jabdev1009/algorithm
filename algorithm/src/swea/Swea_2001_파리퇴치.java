package swea;

import java.util.Scanner;

public class Swea_2001_파리퇴치 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case=1; test_case<=T; test_case++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			// 파리가 있는 공간
			int[][] arr = new int[n][n];
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			// 최대로 잡을 수 있는 파리
			int max = 0;
			// 검사해야하는 범위를 설정 n-m, m*m으로 잡을 수 있는 범위 내에서만 검사하기 위해서
			for(int i=0; i<=n-m; i++) {
				for(int j=0; j<=n-m; j++) {
					// 현재 idx에서 파리채 범위로 잡을 수 있는 파리 합
					int sum = 0;
					// 현재 idx에서 오른쪽, 아랫쪽 m 범위만큼 파리 수를 합해주기
					for(int k=0; k<m; k++) {
						for(int l=0; l<m; l++) {
							sum += arr[i+k][j+l];
						}
					}
					// 최대값이랑 현재 합이랑 비교해서 최신화
					if(sum > max) {
						max = sum;
					}
				}
			}
			System.out.println("#"+test_case+" "+max);
			
		}
	}
}
