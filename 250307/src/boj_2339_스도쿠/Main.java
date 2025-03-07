package boj_2339_스도쿠;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br;
	static int[][] map;
	static int len;
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		len = 9;
		map = new int[len][len];
		
		for(int i=0; i<len; i++) {
			String[] arr = br.readLine().split("");
			for(int j=0; j<len; j++) {
				map[i][j] = Integer.parseInt(arr[j]);
			}
		}
		
		game(0,0);
		
		
	}
	
	static void game(int x, int y) {
		System.out.println(x+" / "+y);
		if(chkMap()) {
			for(int i=0; i<9; i++) {
				for(int j=0; j<9; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
				if(map[i][j] == 0) {
					for(int k=1; k<=9; k++) {
						map[i][j] = k;
						// k를 넣었을 때 현재까지 스도쿠를 만족하는 지 확인
						if(chkRow(j,i)&&chkCol(j,i)&&chkSquare(j,i)) {
							game(j, i);
						}
					}
				}
			}
		}
	}
	static boolean chkRow(int x, int y) {
		boolean flag = true;
		int[] tmp = map[x];
		int[] arr = new int[10];
		for(int i=0; i<9; i++) {
			arr[tmp[i]]++;
		}
		for(int i=1; i<=9; i++) {
			if(arr[i] > 1) {
				flag = false;
			}
		}
		
		return flag;
	}
	static boolean chkCol(int x, int y) {
		boolean flag = true;
		int[] arr = new int[10];
		for(int i=0; i<9; i++) {
			arr[map[i][x]]++;
		}
		for(int i=1; i<=9; i++) {
			if(arr[i] > 1) {
				flag = false;
			}
		}
		
		return flag;
	}
	static boolean chkSquare(int x, int y) {
		boolean flag = true;
		int[] arr = new int[10];
		int startX = 0;
		int startY = 0;
		if(x <=2) {
			startX = 0;
		} else if(x >= 6) {
			startX = 6;
		} else {
			startX = 3;
		}
		if(y <=2) {
			startY = 0;
		} else if(x >= 6) {
			startY = 6;
		} else {
			startY = 3;
		}
		
		
		for(int i=startY; i<=startY+2; i++) {
			for(int j=startX; j<=startX+2; j++) {
				arr[map[i][j]]++;
			}
		}
		for(int i=startY; i<=startY+2; i++) {
			for(int j=startX; j<=startX+2; j++) {
				if(arr[map[j][i]] > 1) {
					flag = false;
				}
			}
		}
		return flag;
	}
	
	static boolean chkMap() {
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
				if(!chkRow(j,i)||!chkCol(j,i)||!chkSquare(j,i)||map[j][i]==0) {
					return false;
				}
			}
		}
		return true;
	}
}
