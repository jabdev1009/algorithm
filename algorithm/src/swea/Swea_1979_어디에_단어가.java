package swea;

import java.util.Scanner;

public class Swea_1979_어디에_단어가 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case=1; test_case<=T; test_case++) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			
			int[][] arr = new int[n][n];
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			int count = 0;
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					int now = arr[i][j];
					if(now == 1) {
						// 세로
						if(i <= n-k) {
							for(int l=1; l<k; l++) {
								if(arr[i+l][j] != 1) {
									break;
								} else if(l == k-1 && arr[i+l][j] == 1) {
									// 3칸이 흰색일 때 위아래로 또다른 흰색이 있는지
									if(i == 0 && i+l < n-1 && arr[i+l+1][j] == 1) {
										break;
									} else if(i+l == n-1 && i != 0 && arr[i-1][j] == 1) {
										break;
									} else if(i > 0 && i+l < n-1 && (arr[i+l+1][j]==1 || arr[i-1][j]==1)) {
										break;
									}
									count++;
								}
							}
						}
						// 가로
						if(j <= n-k) {
							for(int l=1; l<k; l++) {
								if(arr[i][j+l] != 1) {
									break;
								} else if(l == k-1 && arr[i][j+l] == 1) {
									if(j == 0 && j+l < n-1 && arr[i][j+l+1] == 1) {
										break;
									} else if(j+l == n-1 && j != 0 && arr[i][j-1] == 1) {
										break;
									} else if(j > 0 && j+l < n-1 && (arr[i][j+l+1]==1 || arr[i][j-1]==1)) {
										break;
									}
									count++;
								}
							}
						}
					}
				}
			}
			System.out.println("#"+test_case+" "+count);
		}
	}
}
