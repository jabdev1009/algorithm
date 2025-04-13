package boj_7576_토마토;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class Main {
	
	static int N, M, max;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		Queue<int[]> q = new LinkedList<>();
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				int num = Integer.parseInt(st.nextToken());
				map[i][j] = num;
				if(num == 1) {
					q.add(new int[] {j, i, 0});
					visited[i][j] = true;
				} else if(num == -1) {
					visited[i][j] = true;
				}
			}
		}
		
		
		while(!q.isEmpty()) {
			int[] info = q.poll();
			int x = info[0];
			int y = info[1];
			int day = info[2];
			max = Math.max(day, max);
			for(int i=0; i<4; i++) {
				int xx = x + dx[i];
				int yy = y + dy[i];
				
				if(bound(xx, yy) && !visited[yy][xx]) {
					q.add(new int[] {xx, yy, day+1});
					visited[yy][xx] = true;
				}
			}
		}
		
		boolean flag = true;
		
		loop:
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(!visited[i][j]) {
					flag = false;
					break loop;
				}
			}
		}
		
		System.out.println(flag ? max : -1 );
	}
	
	static boolean bound(int x, int y) {
		return x>=0&&y>=0&&x<M&&y<N&&map[y][x] != -1;
	}
}
