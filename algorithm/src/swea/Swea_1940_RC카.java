package swea;

import java.util.Scanner;

public class Swea_1940_RC카 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case=1; test_case<=T; test_case++) {
			int n = sc.nextInt();
			int[][] infos = new int[n][2];
			for(int i=0; i<n; i++) {
				for(int j=0; j<2; j++) {
					int tmp = sc.nextInt();
					infos[i][j] = tmp;
					if(tmp == 0) {
						break;
					}
				}
			}
			int distance = 0;
			int now = 0;
			for(int i=0; i<infos.length; i++) {
				int status = infos[i][0];
				if(status == 1) {
					now += infos[i][1];
				} else if(status == 2) {
					now -= infos[i][1];
					if(now < 0) {
						now = 0;
					}
				}
				distance += now;
			}
			System.out.println("#"+test_case+" "+distance);
			
		}
	}
}
