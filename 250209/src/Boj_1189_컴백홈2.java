import java.util.Scanner;

public class Boj_1189_컴백홈2 {
	static int R;
	static int C;
	static int K;
	static int count = 0;
	static char[][] map;
	static boolean[][] visited;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		K = sc.nextInt();
		
		map = new char[R][C];
		visited = new boolean[R][C];
		visited[R-1][0] = true;
		for(int i=0; i<R; i++) {
			String str = sc.next();
			char[] arr = str.toCharArray();
			map[i] = arr;
		}
		
		int[] start = {R-1,0,1};
		
		dfs(start);
		
		System.out.println(count);
	}
	static void dfs(int[] infos) {
		int x = infos[0];
		int y = infos[1];
		int d = infos[2];
		
		if(d == K) {
			if(x == 0 && y == C-1) {
				count++;
				return;
			}
		} else if(d < K) {
			for(int i=0; i<4; i++) {
				int xx = x + dx[i];
				int yy = y + dy[i];
				if(bound(xx,yy) && map[xx][yy] != 'T' && !visited[xx][yy]) {
					visited[xx][yy] = true;
					dfs(new int[] {xx, yy, d+1});
					visited[xx][yy] = false;
				}
			}
		}
	}
	static boolean bound(int x, int y) {
		return x>=0&&x<R&&y>=0&&y<C;
	}
}
