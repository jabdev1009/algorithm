package swea_2105_디저트카페;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Solution {
	
	static int N, startX, startY;
	static int[][] map;
	static int[] dx = {1,-1,-1,1};
	static int[] dy = {1,1,-1,-1};
	static int max;
	static Set<Integer> sel;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = null;
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			sb = new StringBuilder();
			sb.append('#').append(tc).append(' ');
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			
			for(int i=0; i<N; i++) {
				String[] arr = br.readLine().split(" ");
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(arr[j]);
				}
			}

			
			max = -1;
			for(int i=0; i<N-2; i++) {
				for(int j=1; j<N-1; j++) {
					startX = j;
					startY = i;
					sel = new HashSet<>();
					sel.add(map[i][j]);
					dfs(j, i, 0);
				}
			}
			
			sb.append(max);
			System.out.println(sb);
			
		}
	}
	
	static void dfs(int x, int y, int d) {
		for(int i=d; i<=d+1 && i<4; i++) {
			int xx = x + dx[i];
			int yy = y + dy[i];

			if(xx == startX && yy == startY) {
				max = Math.max(max, sel.size());
				return;
			}

			if(bound(xx, yy) && sel.add(map[yy][xx])) {
				dfs(xx, yy, i);
				sel.remove(map[yy][xx]);
			}
		}
	}
	static boolean bound(int x, int y) {
		return x>=0&&y>=0&&x<N&&y<N;
	}
}
