package swea_5653_줄기세포배양;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	
	static class Cell implements Comparable<Cell>{
		int x;
		int y;
		int hp;
		int start;
		int now;
		public Cell(int x, int y, int hp, int start, int now) {
			this.x = x;
			this.y = y;
			this.hp = hp;
			this.start = start;
			this.now = now;
		}
		@Override
		public int compareTo(Cell o) {
			if(this.now == o.now) {
				int hp1 = this.hp;
				int hp2 = o.hp;
				return hp2-hp1;
			}
			return this.now - o.now;
		}
	}
	
	static Cell[][] map;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {-1,1,0,0};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int k = sc.nextInt();
			
			map = new Cell[m+(2*k)][n+(2*k)];
			Queue<Cell> queue = new PriorityQueue<>();
			
			int w = n+k;
			int l = m+k;
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					int hp = sc.nextInt();
					Cell c = new Cell(w+j, l+i, hp, 0, 0);
					map[l+i][w+j] = c;
					queue.offer(c);
				}
			}
			
			while(k > 0) {
				Cell c = queue.poll();
				int x = c.x;
				int y = c.y;
				int start = c.start;
				int hp = c.hp;
				int now = c.now;
				// 세포가 활성화 상태인지 확인
				if(start+hp >= now && start +hp < now) {
					for(int i=0; i<4; i++) {
						int xx = x + dx[i];
						int yy = y + dy[i];
						int time = now + 1;
						if(map[yy][xx] == null) {
							map[yy][xx] = new Cell(xx, yy, hp, now, time);
						}
					}
				}
				k--;
			}
		}
	}
}

























