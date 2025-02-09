import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Boj_2468_안전영역 {
	static int n;
	static int[][] map;
	static boolean[][] visited;
	static Set<Integer> heights;
	static int max = 0;
	
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		map = new int[n][n];
		heights = new HashSet<>();
		// 비가 얼만큼 올지 몰라서 높이 정보에 경우의 수를 추가해 주기 위해 
		// 안오는 경우, 최대 높이만큼 오는 경우를 추가해 줌
		// 이외에는 높이정보가 있는 경우에만 검사
		// 1~100까지 검사하는 거랑 경우의 수를 줄여서 진행하는 것 중 어떤게 좋은지?
		heights.add(0);
		heights.add(100);
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				map[i][j] = sc.nextInt();
				heights.add(map[i][j]);
			}
		}
		
		count();
		
		System.out.println(max);
	}
	
	static void count() {
		for(int height : heights) {
			int count = 0;
			visited = new boolean[n][n];
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					int num = map[i][j];
					if(num > height && !visited[i][j]) {
						chkSpace(i,j,height);
						count++;
					}
				}
			}
			max = max > count ? max : count;
		}
	}
	static void chkSpace(int x, int y, int h) {
		visited[x][y] = true;
		for(int i=0; i<4; i++) {
			int xx = x+dx[i];
			int yy = y+dy[i];
			if(bound(xx,yy) && !visited[xx][yy] && map[xx][yy] > h) {
				visited[xx][yy] = true;
				chkSpace(xx,yy,h);
				
			}
		}
	}
	static boolean bound(int x, int y) {
		return x>=0&&y>=0&&x<n&&y<n;
	}
}
