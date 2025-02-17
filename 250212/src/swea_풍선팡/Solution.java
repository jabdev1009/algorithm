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
			
			// 꽃가루 정보
			int[][] map = new int[n][m];
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			// 꽃가루의 최대값을 담아줄 변수
			int max = 0;
			// 전체 꽃가루 정보를 돌면서 
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					// 해당 위치가 터졌을 때 가로세로 얼마나 터뜨릴지
					int tmp = map[i][j];
					// 꽃가루의 합을 담아줄 변수
					int sum = tmp;
					// 가로, 세로로 얼마나 터뜨릴지 거리만큼 반복
					for(int l=1; l<=tmp; l++) {
						// 4가지 방향에 대해
						for(int k=0; k<4; k++) {
							// 델타값 * 거리
							int xx = j + l*dx[k];
							int yy = i + l*dy[k];
							
							// 해당 위치가 map안에 있으면 해당 좌표 꽃가루 더해줌
							if(bound(xx,yy)) {
								sum += map[yy][xx];
							}
						}
					}
					// 현재위치 터졌을 때 꽃가루가 최대임?
					if(sum>max) {
						max = sum;
					}
				}
			}
			
			System.out.println("#"+tc+" "+max);
		}
	}
	// 입력된 좌표가 범위내에 있는지 return
	static boolean bound(int x, int y) {
		return x>=0&&x<m&&y>=0&&y<n;
	}
}
