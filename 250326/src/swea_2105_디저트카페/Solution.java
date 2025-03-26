package swea_2105_디저트카페;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	
	static int N;
	static int[][] map;
	static int[] dx = {1,-1,-1,1};
	static int[] dy = {1,1,-1,-1};
	static int min;
	
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

			
			min = -1;
			
			for(int i=0; i<N-1; i++) {
				for(int j=1; j<N-1; j++) {
					dfs(j, i, 0, 0);
				}
			}
			
			sb.append(min);
			System.out.println(sb);
			
		}
	}
	
	static void dfs(int x, int y, int d, int sum) {
		if(d == 4) {
			Math.max(min, sum);
			return;
		}
		
		for(int i=0; i<N-x; i++) {
			
		}
		
	}
	
	
	static boolean bound(int x, int y) {
		return x>=0&&y>=0&&x<N&&y<N;
	}
}
