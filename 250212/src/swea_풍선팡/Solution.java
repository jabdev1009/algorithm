package swea_풍선팡;

import java.util.Scanner;

public class Solution {
	static int n;
	static int m;
	static int[] dx  = {0,0,1,-1};
	static int[] dy  = {1,-1,0,0};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			n = sc.nextInt();
			m = sc.nextInt();
			
			int[][] map = new int[n][m];
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			int max = 0;
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					int tmp = map[i][j];
					int sum = tmp;
					for(int l=1; l<=tmp; l++) {
						for(int k=0; k<4; k++) {
							int xx = j + l*dx[k];
							int yy = i + l*dy[k];
							
							if(bound(xx,yy)) {
								sum += map[yy][xx];
							}
						}
					}
					if(sum>max) {
						max = sum;
					}
				}
			}
			
			System.out.println("#"+tc+" "+max);
		}
	}
	static boolean bound(int x, int y) {
		return x>=0&&x<m&&y>=0&&y<n;
	}
}
