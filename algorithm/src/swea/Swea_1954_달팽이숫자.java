package swea;

import java.util.Scanner;

public class Swea_1954_달팽이숫자 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] dy = {0, 1, 0, -1};
		int[] dx = {1, 0, -1, 0};
				
		for(int test_case=1; test_case<=T; test_case++) {
			int n = sc.nextInt();
			int[][] arr = new int[n][n];
			int idx = 0;
			int x = 0;
			int y = 0;
			for(int i=1; i<=n*n; i++) {
				arr[y][x] = i;
				if(
					x + dx[idx] > n-1 || x + dx[idx] < 0 || 
					y + dy[idx] > n-1 || y + dy[idx] < 0 ||  
					arr[y+dy[idx]][x+dx[idx]] != 0
				) {
					idx = (idx + 1) % 4;
				}
				x += dx[idx];
				y += dy[idx];
			}
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					System.out.print(arr[i][j]+" ");
				}
				System.out.println();
			}
		}
	}
}
