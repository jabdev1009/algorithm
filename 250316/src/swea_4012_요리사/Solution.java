package swea_4012_요리사;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	
	static int N;
	static int min;
	
	static int[][] map;
	
	static boolean[] picked;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			
			N = sc.nextInt();
			picked = new boolean[N];
			map = new int[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			min = 0;
			
			cook(0,0);
			
		}
	}
	static void cook(int idx, int size) {
		if(size == N/2) {
			
			min = Math.min(min, getResult());
			return;
		}
		
		for(int i=idx; i<N; i++) {
			picked[i] = true;
			cook(i+1, size+1);
		}
		System.out.println(Arrays.toString(picked));
	}
	static int getResult() {
		int pick=0;
		int left=0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(picked[i] && picked[j]) {
					pick += map[i][j];
				} else if(!picked[i] && !picked[j]) {
					left += map[i][j];
				}
				
			}
		}
		return Math.abs(pick - left);
	}
}
