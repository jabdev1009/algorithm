package swea_재미있는_오셀로_게임;

import java.util.Scanner;

// 돌을 입력받으면서 주변에 다른색 돌이 있는 경우
// 해당 방향에 같은 색 돌이 있으면 사이에 있는 돌들의 색을 바꿔주자
public class Solution {
	static int n;
	static int[][] board;
	// 상하좌우,대각선을 나타내는 델타
	static int[] dx = {0,0,1,-1,1,1,-1,-1};
	static int[] dy = {1,-1,0,0,1,-1,1,-1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			n = sc.nextInt();
			int m = sc.nextInt();
			
			// 게임판을 만들어줌, 기본적으로 돌이 놓이는 곳에 돌을 둔다.
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
			
			// 한 턴씩 돌아가며 돌을 둔다.
			for(int turn=0; turn<m; turn++) {
				int x = sc.nextInt() -1;
				int y = sc.nextInt() -1;
				int color = sc.nextInt();
				
				// 돌을 둔 곳 표시
				board[y][x] = color;
				
				// 주변 탐색
				for(int j=0; j<8; j++) {
					int xx = x + dx[j];
					int yy = y + dy[j];
					// 주변위치가 범위내에 있는지, 지금 둔 돌이랑 다른색, 빈공간은 아닌지 확인
					if(bound(xx,yy) && board[yy][xx] != color && board[yy][xx] != 0) {
						// 인접한 돌 중 다른색의 돌이 있다면 해당 방향에 같은색 돌이 있는지 확인
						// 있으면 사이에 있는 돌의 색을 바꿔주고 없으면 끝
						int[] xy = hasSameColor(xx, yy, j, color);
						// 탐색중인 방향에 현재 둔 돌과 같은 색이 있다면
						if(xy != null) {
							// 같은색 돌의 좌표
							int sX = xy[0];
							int sY = xy[1];
							int tmpX = xx;
							int tmpY = yy;
							
							// 같은 색 돌의 좌표와 같아질 때 까지
							while(sX != tmpX || sY != tmpY) {
								// 색 변경하고
								board[tmpY][tmpX] = color;
								// 해당 방향으로 이동
								tmpX += dx[j];
								tmpY += dy[j];
							}
						}
					}
				}
			}
			// 갯수를 센다
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
	// 현재 위치, 방향, 색 정보로
	static int[] hasSameColor(int x, int y, int d, int color) {
		int[] xy = null;
		// 탐색중인 방향으로 쭉 가는데 벽에 닿을 때 까지
		while(bound(x+=dx[d], y+=dy[d])) {
			// 빈공간 있으면 끝, 색깔 변경 대상이 아님
			if(board[y][x] == 0) {
				break;
			}
			// 나랑 같은 색인걸 찾으면 거기 좌표 담아서 return
			if(board[y][x] == color) {
				xy = new int[] {x, y};
				break;
			} 
		}
		return xy;
	}
}
