package jungol;

import java.util.Scanner;

public class Jo_1733_오목 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] arr = new int[19][19];
		
		for(int i=0; i<19; i++) {
			for(int j=0; j<19; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		
		int result = 0;
		int x = 0;
		int y = 0;
		
		loop:
		for(int i=0; i<19; i++) {
			for(int j=0; j<19; j++) {
				boolean chk = true;
				int color = arr[i][j];
				// 세로 확인
				if(color != 0) {
					if(i <= 14) {
						for(int k=1; k<=4; k++) {
							if(color != arr[i+k][j]) {
								chk = false;
								break;
							}
						}
						if( chk &&
							(i == 14 && color != arr[i-1][j] ||
							i == 0 && color != arr[i+5][j] || 
							i < 14 && i > 0 && color != arr[i-1][j] && color != arr[i+5][j])
						) {
							result = color;
							x = i;
							y = j;
							break loop;
						}
					}
					chk = true;
					// 가로확인
					if(j <= 14) {
						for(int k=1; k<=4; k++) {
							if(color != arr[i][j+k]) {
								chk = false;
								break;
							} 
						}
						if( chk &&
							(j == 14 && color != arr[i][j-1] ||
							j == 0 && color != arr[i][j+5] || 
							j < 14 && j > 0 && color != arr[i][j-1] && color != arr[i][j+5])
						) {
							result = color;
							x = i;
							y = j;
							break loop;
						}
					}
					chk = true;
					// 대각(우하)
					if(i <= 14 && j <= 14) {
						for(int k=1; k<=4; k++) {
							if(color != arr[i+k][j+k]) {
								chk = false;
								break;
							} 
						}
						if( chk &&
							((i==0 && j==14 || i==14 && j==0) ||
							(i==14 || j==14) && color != arr[i-1][j-1] ||
							(i==0 || j== 0) && color != arr[i+5][j+5] || 
							i < 14 && j < 14 && i > 0 && i > 0 && color != arr[i-1][j-1] && color != arr[i+5][j+5])
						) {
							result = color;
							x = i;
							y = j;
							break loop;
						}
					}
					chk = true;
					// 대각(우상)
					if(i>=4 && j<=14) {
						for(int k=1; k<=4; k++) {
							if(color != arr[i-k][j+k]) {
								chk = false;
								break;
							} 
						}
						if( chk &&
							((i==4 && j==0 || i==18 && j== 14) ||
							(i==4 || j== 14) && color != arr[i+1][j-1] ||
							(i==18 || j== 0) && color != arr[i-5][j+5] || 
							i < 18 && j < 14 && i > 4 && j > 0 && color != arr[i+1][j-1] && color != arr[i-5][j+5])
						) {
							result = color;
							x = i;
							y = j;
							break loop;
						}
					}
				}
			}
		}
		System.out.println(result);
		if(result != 0) {
			System.out.println((x+1) + " " + (y+1));
		}
	}
}