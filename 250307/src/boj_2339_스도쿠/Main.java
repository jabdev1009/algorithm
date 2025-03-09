package boj_2339_스도쿠;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int[][] map = new int[9][9];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 9; i++) {
			String[] line = br.readLine().split("");
			for (int j = 0; j < 9; j++) {
				map[i][j] = Integer.parseInt(line[j]);
			}
		}

		game(0, 0);
	}

	static boolean game(int x, int y) {
		if (x == 9) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
			return true;
		}

		int nx = (y == 8) ? x + 1 : x;
		int ny = (y + 1) % 9;

		if (map[x][y] != 0) {
			return game(nx, ny);
		}

		for (int num = 1; num <= 9; num++) {
			if (chkMap(x, y, num)) {
				map[x][y] = num;
				if (game(nx, ny))
					return true;
				map[x][y] = 0;
			}
		}

		return false;
	}

	static boolean chkMap(int x, int y, int num) {
		// 행과 열
		for (int i = 0; i < 9; i++) {
			if (map[x][i] == num || map[i][y] == num)
				return false;
		}

		// 3x3 사각형
		int sx = (x / 3) * 3;
		int sy = (y / 3) * 3;
		for (int i = sx; i < sx + 3; i++) {
			for (int j = sy; j < sy + 3; j++) {
				if (map[i][j] == num)
					return false;
			}
		}

		return true;
	}
}
