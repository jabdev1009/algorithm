package swea;

import java.util.Scanner;

public class Swea_7236_저수지 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case=1; test_case<=T; test_case++) {
			int n = sc.nextInt();
			String[][] arr = new String[n][n];
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					arr[i][j] = sc.next();
				}
			}
			
			int max = 0;
			int countW = 0;
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(i > 0 && arr[i-1][j].equals("W")) {
						countW++;
					}
					if(i < n-1 && arr[i+1][j].equals("W")) {
						countW++;
					}
					if(j > 0 && arr[i][j-1].equals("W")) {
						countW++;
					}
					if(j < n-1 && arr[i][j+1].equals("W")) {
						countW++;
					}
					if(i>0 && j > 0 && arr[i-1][j-1].equals("W")) {
						countW++;
					}
					if(i > 0 && j < n-1 && arr[i-1][j+1].equals("W")) {
						countW++;
					}
					if(i < n-1 && j > 0 && arr[i+1][j-1].equals("W")) {
						countW++;
					}
					if(i < n-1 && j < n-1 && arr[i+1][j+1].equals("W")) {
						countW++;
					}
					if(countW > max) {
						max = countW;
					}
					countW = 0;
				}
			}
			System.out.println("#"+test_case+" "+max);
		}
	}
}
