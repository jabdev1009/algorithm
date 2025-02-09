import java.util.Scanner;

public class Boj_1012_유기농배추 {
	static int n;
	static int m;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			n = sc.nextInt();
			m = sc.nextInt();
			
			map = new int[n][m];
			visited = new boolean[n][m];
			
			int k = sc.nextInt();
			for(int i=0; i<k; i++) {
				map[sc.nextInt()][sc.nextInt()] = 1;
			}
			
			int count = 0;
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(map[i][j] == 1 && !visited[i][j]) {
						dfs(i,j);
						count++;
					}
				}
			}
			System.out.println(count);
		}
	}
	static void dfs(int x, int y) {
		visited[x][y] = true;
		
		for(int i=0; i<4; i++) {
			int xx = x+dx[i];
			int yy = y+dy[i];
			if(bound(xx,yy)&& map[xx][yy] == 1 && !visited[xx][yy]) {
				dfs(xx,yy);
			}
		}
	}
	
	
	static boolean bound(int x, int y) {
		return x>=0&&x<n&&y>=0&&y<m;
	}
}
