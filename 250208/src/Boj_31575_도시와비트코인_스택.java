import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Boj_31575_도시와비트코인_스택 {
	static int n;
	static int m;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {1, 0};
	static int[] dy = {0, 1};
	static Stack<int[]> s;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
			
		n = sc.nextInt();
		m = sc.nextInt();
		
		
		map = new int[m][n];
		visited = new boolean[m][n];
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		s = new Stack<int[]>();
		
		visited[0][0] = true;
		int[] start = {0,0};
		s.push(start);
		while(!s.isEmpty()) {
			int[] now = s.pop();
			int x = now[0];
			int y = now[1];
			for(int i=0; i<2; i++) {
				int xx = x + dx[i];
				int yy = y + dy[i];
				if(bound(xx,yy) && map[xx][yy] != 0 && !visited[xx][yy]) {
					visited[xx][yy] = true;
					s.push(new int[] {xx, yy});
					
				}
			}
		}
		System.out.println(visited[m-1][n-1] ? "Yes" : "No");
	}
	static boolean bound(int x, int y) {
		return x>=0&&x<m&&y>=0&&y<n;
	}
}
