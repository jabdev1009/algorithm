import java.util.Scanner;

public class Swea_1210_Ladder1 {
	// 도착지점에서 출발지점을 찾아감 -> 위, 좌, 우만 확인
	static int[] dx = {0, 1, -1};
	static int[] dy = {-1, 0, 0};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;
		for(int tc=1; tc<=T; tc++) {
			int n = sc.nextInt();
			int[][] map = new int[100][100];
			
			int x=0;
			int y=0;
			// 2차원 배열을 만들고
			for(int i=0; i<100; i++) {
				for(int j=0; j<100; j++) {
					map[i][j] = sc.nextInt();
					// 도착지점을 찾고 거꾸로 올라간다
					if(map[i][j] == 2) {
						x = j;
						y = i;
					}
				}
			}
			// 현재 진행중인 방향
			int d = 0;
			
			// 도착할 때까지 반복
			while(true) {
				// 위쪽 테두리에 닿으면 끝
				if(y == 0) {
					break;
				}
				// 위, 좌, 우를 검사 -> 좌우 중 만나는게 있으면 해당 방향으로 계속 이동 -> 올라가는 방향을 만나면 위로 이동 => 반복
				
				// 지금 위로 올라가는 중이니
				if(d != 0) {
					// 좌우로 가는 중에 위로 가는 길 만나면 현재 진행중인 방향 바꿔
					if(map[y-1][x] == 1) {
						d = 0;
					} 
				} else {
					// 위로 올라가는 중에 좌, 우로 가는 길 있으면 방향 바꿔
					if(bound(x+1, y) && map[y][x+1] == 1) {
						d = 1;
					} else if(bound(x-1,y) && map[y][x-1] == 1) {
						d = 2;
					}
				}
				// 바뀐 방향으로 한칸 가
				x+=dx[d];
				y+=dy[d];
			}
			
			System.out.println("#"+n+" "+x);
		}
	}
	// 들어온 좌표가 범위 내에 있는지 확인
	static boolean bound(int x, int y) {
		return x>=0 && x<100 && y>=0 && y<100;
	}
}
