package swea_러시아;

import java.util.Scanner;

/*
 * 흰색		W : 1줄 이상
 * 파란색	B : 1줄 이상
 * 빨간색	R : 1줄 이상
 * 
 * 행의 수 N
 * 열의 수 M
 * 
 * 제일 위, 아래의 색은 고정
 * 
 * 파란색의 위치 -> 중간에서 파란색의 수가 가장 많은?
 * 흰-파, 파-빨
 */
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			
			// 칸 수
			int count = 0;
			
			char[][] flag = new char[n][];
			for(int i=0; i<n; i++) {
				flag[i] = sc.next().toCharArray();
				// 첫째, 마지막 줄은 색 고정
				if(i == 0) {
					for(int j=0; j<m; j++) {
						if(flag[i][j] != 'W') {
							count++;
						}
					}
				} else if(i == n-1) {
					for(int j=0; j<m; j++) {
						if(flag[i][j] != 'R') {
							count++;
						}
					}
				}
			}
			// WBR순으로 색 갯수
			int[][] colorCount = new int[n-2][3];
			for(int i=1; i<n-1; i++) {
				for(int j=0; j<m; j++) {
					if(flag[i][j] == 'W') {
						colorCount[i-1][0]++;
					} else if(flag[i][j] == 'B') {
						colorCount[i-1][1]++;
					} else {
						colorCount[i-1][2]++;
					}
				}
			}
			
			
			int tmpCount = 0;
			for(int i=0; i<colorCount.length; i++) {
				// i행이 B일 때 0~i-1행 i+1~color.len
				int mid = colorCount[i][1];
				int top = 0;
				int bottom = 0;
				
				for(int j=0; j<=i; j++) {
					int w =0;
					int b =0;
					int tmptmp=0;
					for(int k=0; k<j; k++) {
						w+=colorCount[k][0];
					}
					for(int k=j; k<i; k++) {
						b+=colorCount[k][1];
					}
					if(w+b > tmptmp) {
						tmptmp = w+b;
					}
					if(tmptmp>top) {
						top = tmptmp;
					}
					w =0;
					b =0;
				}
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				for(int j=i+1; j<colorCount.length; j++) {
					// B, R 중 합이 최대
					int b =0;
					int r =0;
					int tmptmp =0;
					for(int k=i+1; k<j; k++) {
						b+=colorCount[k][1];
					}
					for(int k=j; k<colorCount.length; k++) {
						r+=colorCount[k][2];
					}
					if(b+r>tmptmp) {
						tmptmp = b+r;
					}
					if(tmptmp > bottom) {
						bottom = tmptmp;
					}
					b=0;
					r=0;
				}
				
				
				if(mid+top+bottom > tmpCount) {
					tmpCount = mid+top+bottom; 
				}
			}
			tmpCount = (colorCount.length * m) - tmpCount;
			System.out.println("#" + tc+" " +(count+tmpCount));
		}
	}
}
