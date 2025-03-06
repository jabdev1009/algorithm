package boj_2630_색종이만들기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static BufferedReader br;
	
	static int[][] map;
	static int n;
	
	static int white;
	static int blue;
	
	public static void main(String[] args) throws Exception{
		br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		map = new int[n][n];
		for(int i=0; i<n; i++) {
			String[] tmp = br.readLine().split(" ");
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(tmp[j]);
			}
		}
		
		chkColor(0,0,n);
		
		System.out.println(white+"\n"+blue);
	}
	
	
	static void chkColor(int x, int y, int len) {
		boolean flag = true;
		int color = map[y][x];
		loop:
		for(int i=x; i<x+len; i++) {
			for(int j=y; j<y+len; j++) {
				if(color != map[j][i]) {
					flag =  false;
					break loop;
				}
			}
		}
		
		if(flag) {
			if(color == 1) {
				blue++;
			} else {
				white++;
			}
		} else {
			int newLen = len/2; 
			chkColor(x,y, newLen);
			chkColor(x+newLen,y, newLen);
			chkColor(x,y+newLen, newLen);
			chkColor(x+newLen,y+newLen, newLen);
		}
	}
}
