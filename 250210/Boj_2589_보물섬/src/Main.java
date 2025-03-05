import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	// 보물의 위치를 어떻게 정할 수 있을지
	// 순회하면서 땅일 때 -> bfs 해서 마지막 큐가 나오는 시간이 최대인 경우가 보물이 있는 장소
	static int l;
	static int w;
	static char[][] map;
	static boolean[][] visited;
	static int[] dx = {1,-1,0,0};	
	static int[] dy = {0,0,1,-1};
	static int max;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		l = sc.nextInt();
		w = sc.nextInt();
		
		map = new char[l][w];
		sc.nextLine();
		for(int i=0; i<l; i++) {
			String str = sc.nextLine();
			map[i] = str.toCharArray();
		}
		
		max = 0;
		for(int i=0; i<l; i++) {
			for(int j=0; j<w; j++) {
				if(map[i][j] == 'L') {
					visited = new boolean[l][w];
					bfs(j,i);
				}
			}
		}
		
		System.out.println(max);
	}
	static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>(); 
		visited[y][x] = true;
		q.offer(new int[] {x,y,0});
		
		while(!q.isEmpty()) {
			int[] xyt = q.poll();
			if(xyt[2] > max) {
				max = xyt[2];
			}
			for(int i=0; i<4; i++) {
				int xx = xyt[0] + dx[i];
				int yy = xyt[1] + dy[i];
				int tt = xyt[2] + 1;
				if(bound(xx, yy) && map[yy][xx] == 'L' && !visited[yy][xx]) {
					visited[yy][xx] = true;
					q.offer(new int[] {xx, yy, tt});
				}
			} 
		}
		
	}
	static boolean bound(int x, int y) {
		return x>=0 && x<w && y >=0 && y<l;
	}
}
