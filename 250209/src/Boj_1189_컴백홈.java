import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj_1189_컴백홈 {
	static int R;
	static int C;
	static int K;
	static int count = 0;
	static char[][] map;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		K = sc.nextInt();
		
		map = new char[R][C];
		for(int i=0; i<R; i++) {
			String str = sc.next();
			char[] arr = str.toCharArray();
			map[i] = arr;
		}
		
		int[] start = {0,0,1};
		boolean[][] visited = new boolean[R][C];
		visited[0][0] = true;
		
		Object[] infos = {start, visited};
		
		bfs(infos);
		
		System.out.println(count);
	}
	static void bfs(Object[] infos) {
		Queue<Object[]> q = new LinkedList<>();
		q.add(infos);
		while(!q.isEmpty()) {
			Object[] now = q.poll();
			int[] info1 = (int[])now[0];
			int x = info1[0];
			int y = info1[1];
			int d = info1[2];
			
			boolean[][] visited = (boolean[][])now[1];
			if(x == R-1 && y == C-1 && d == K) {
				count++;
			} else if(d<K) {
				for(int i=0; i<4; i++) {
					int xx = x+dx[i];
					int yy = y+dy[i];
					int dd = d+1;
					boolean[][] arr = new boolean[R][C];
					for(int j=0; j<arr.length; j++) {
						arr[j] = visited[j].clone();
					}
					if(bound(xx,yy) && map[xx][yy] != 'T' && !arr[xx][yy]) {
						arr[xx][yy] = true;
						Object[] next = {new int[] {xx,yy,dd}, arr};
						q.offer(next);
					}
				}
			}
		}
	}
	static boolean bound(int x, int y) {
		return x>=0&&x<R&&y>=0&&y<C;
	}
}
