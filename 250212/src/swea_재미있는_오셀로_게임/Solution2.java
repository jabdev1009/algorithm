package swea_재미있는_오셀로_게임;

import java.util.Scanner;

public class Solution2 {
	static int n;
	static int[][] board;
	static int[] dx = {0,0,1,-1,1,1,-1,-1};
	static int[] dy = {1,-1,0,0,1,-1,1,-1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			n = sc.nextInt();
			int m = sc.nextInt();
			
			board = new int[n][n];
			for(int i=(n/2)-1; i<=n/2; i++) {
				for(int j=(n/2)-1; j<=n/2; j++) {
					if(i == j) {
						board[i][j] = 2; 
					} else {
						board[i][j] = 1; 
					}
				}
			}
			
			for(int turn=0; turn<m; turn++) {
				int x = sc.nextInt() -1;
				int y = sc.nextInt() -1;
				int color = sc.nextInt();
				
				for(int i=0; i<dx.length; i++) {
					int xx = x + dx[i];
					int yy = y + dy[i];
					if(bound(xx,yy) && board[xx][yy] != color) {
						// 인접한 돌 중에 색이 다른게 있다면
						// 그 방향으로 나와 같은 색이 있는지 확인
						int[] xy = sameColorXy(xx, yy, i, color);
						if(xy != null) {
							int sameColorX = xy[0];
							int sameColorY = xy[1];
							int tmpX = xx;
							int tmpY = yy;
							while(tmpX != sameColorX || tmpY != sameColorY) {
								board[tmpY][tmpX] = color;
								xx+=dx[i];
								yy+=dy[i];
							}
						}
					}
					
				}
				
			}
			int countW = 0;
			int countB = 0;
			for(int c=0; c<n; c++ ) {
				for(int cc=0; cc<n; cc++) {
					if(board[c][cc] == 1) {
						countB++;
					} else if(board[c][cc] == 2) {
						countW++;
					}
				}
			}
			System.out.println("#"+tc+" "+countB + " " + countW);
		}
	}
	static boolean bound(int x, int y) {
		return x>=0&&x<n&&y>=0&&y<n;
	}
	static int[] sameColorXy(int x, int y, int d, int color) {
		int[] xy = null;
		while(bound(x+=dx[d], y+=dy[d])) {
			if(board[x][y] == color) {
				xy = new int[] {x, y};
				break;
			}
		}
				
		return xy;
	}
}
