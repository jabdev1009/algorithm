package boj_6087_레이저통신;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static final int INF = Integer.MAX_VALUE;
	static int W, H, sX, sY, eX, eY;
	static char[][] map;
	static int[][] dist;
	static boolean[][] visited;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {-1,1,0,0};
	
	static PriorityQueue<int[]> pq;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		map = new char[H][W];
		dist = new int[H][W];
		visited = new boolean[H][W];
		sX = -1;
		for(int i=0; i<H; i++) {
			char[] arr = br.readLine().toCharArray(); 
			for(int j=0; j<W; j++) {
				char c = arr[j];
				map[i][j] = c; 
				if(c == 'C') {
					if(sX == -1) {
						sX = j;
						sY = i;
					} else {
						eX = j;
						eY = i;
					}
				}	
				dist[i][j] = INF;
			}
		}
		pq = new PriorityQueue<>((a,b)->a[3]-b[3]);
		pq.add(new int[] {sX, sY, -1, 0});
		dist[sY][sX] = 0;
		while(!pq.isEmpty()) {
			int[] info = pq.poll();
			int x = info[0];
			int y = info[1];
			int d = info[2];
			int count = info[3];
			
			if(visited[y][x] && dist[y][x] < count) {
				continue;
			}
			visited[y][x] = true;
			for(int i=0; i<4; i++) {
				int xx = x + dx[i];
				int yy = y + dy[i];
				int nCount = i == d || d == -1 ? count : count + 1;
				if(bound(xx, yy) && dist[yy][xx] >= nCount) {
					dist[yy][xx] = nCount;
					pq.add(new int[] {xx, yy, i, nCount});
				}
			}
		}
		System.out.println(dist[eY][eX]);
	}
	static boolean bound(int x, int y) {
		return x>=0&&y>=0&&x<W&&y<H&&map[y][x] != '*';
	}
}
