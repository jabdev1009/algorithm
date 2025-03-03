package swea_1974_스도쿠검증;

import java.util.Scanner;

public class Solution {
	static int[] dx = {0,0,0,1,1,1,-1,-1,-1};
	static int[] dy = {0,1,-1,0,1,-1,0,1,-1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb;
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");
			int[][] map = new int[9][9];
			
			for(int i=0; i<9; i++) {
				for(int j=0; j<9; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			// 가로, 세로, 중앙기준 8방
			int rSum;
			int cSum;
			int sSum;
			boolean flag = true;
			loop :
			for(int i=0; i<9; i++) {
				rSum = 0;
				cSum = 0;
				sSum = 0;
				for(int j=0; j<9; j++) {
					rSum += map[i][j];
					cSum += map[j][i];
					
					if(i % 3 == 1 && j % 3 == 1) {
						for(int k=0; k<9; k++) {
							sSum += map[i+dy[k]][j+dx[k]];
						}
					}
					if(sSum !=0 && sSum != 45) {
						sb.append(0);
						flag = false;
						break loop;
					}
					sSum = 0;
				}
				if(rSum != 45 || cSum != 45) {
					sb.append(0);
					flag = false;
					break loop;
				}
			}
			if(flag) {
				sb.append(1);
			}
			System.out.println(sb);
		}
	}
}


