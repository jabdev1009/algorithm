package swea_줄기세포배양;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	static int n;
	static int m;
	static int k;
	static int[][][] map;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	public static void main(String[] args) {
		// 위치정보(x, y), 생명력, 번식시간, 현재시간
		// 상하좌우로 이동
		// 동시에 도착하면 생명력이 높은 세포가 차지
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			n = sc.nextInt();
			m = sc.nextInt();
			k = sc.nextInt(); 
		
			Queue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[2]-o2[2]; 
				}
			});
			map = new int[n][m][4];
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					int num = sc.nextInt(); 
					map[i][j] = new int[] {j,i,num,0,0};
					if(map[i][j][2] != 0) {
						q.offer(map[i][j]);
					}
				}
			}
			
			while(!q.isEmpty()) {
				int[] cellInfo = q.poll();
				int x = cellInfo[0];
				int y = cellInfo[1];
				int hp = cellInfo[2];
				int reproduct = cellInfo[3];
				int nowTime = cellInfo[4];
				
				for(int i=0; i<4; i++) {
					int xx = x+dx[i];
					int yy = y+dy[i];
					nowTime++;
					if(bound(xx, yy) && map[yy][xx][2] == 0 && nowTime<k) {
						// 활성화 여부
						if(reproduct + hp <= nowTime && reproduct + (2*hp) >= nowTime) {
							map[yy][xx] = new int[] {xx, yy, hp, nowTime, nowTime};
							q.offer(map[yy][xx]);
						} 
					}
				}
			}
			int count = 0;
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					int[] arr = map[i][j];
					int hp = arr[2];
					int t = arr[3];
					if(hp+t <= k && k > t + (2*hp)) {
						count++;
					}
				}
			}
			
			System.out.println("#" + tc + " " + count);
		}
	}
	static boolean bound(int x, int y) {
		return x>=0&&x<m&&y>=0&&y<n;
	}
}
