package swea_5656_벽돌깨기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {
	
	static int N,W,H,min;
	static int[][] map;
	static Stack<Integer> stack;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++, sb.append('\n')) {
			st = new StringTokenizer(br.readLine());
			sb.append('#').append(tc).append(' ');
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			min = Integer.MAX_VALUE;
			map = new int[H][W];
			stack = new Stack();
			for(int i=0; i<H; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			shoot(0, map);
			sb.append(min);
		}
		System.out.println(sb.toString());
	}
	
	static void shoot(int n, int[][] map) {
		if(n == N) {
			min = Math.min(min, countBlock(map));
			return;
		}	
		for(int i=0; i<W; i++) {
			int[][] mapCopy = new int[H][W];
			for(int j=0; j<H; j++) {
				mapCopy[j] = Arrays.copyOf(map[j], W);
			}
			boolean[][] visited = new boolean[H][W];
			Queue<int[]> blocks = new ArrayDeque<>();
			
			int h = -1;
			for(int j=0; j<H; j++) {
				if(mapCopy[j][i] != 0) {
					h = j;
					break;
				}
			}
			if(h == -1) continue;
			
			blocks.add(new int[] {i, h});
			while(!blocks.isEmpty()) {
				int[] info = blocks.poll();
				int x = info[0];
				int y = info[1];
				int power = mapCopy[y][x]-1;
				if(power == 0) {
					visited[y][x] = true;
					continue;
				}
				
				for(int j=0; j<4; j++) {
					int xx = x;
					int yy = y;
					for(int k=1; k<=power; k++) {
						xx += dx[j];
						yy += dy[j];
						if(bound(xx, yy)) {
							visited[yy][xx] = true;
							blocks.add(new int[] {xx, yy});
						}
					}
				}
			}
			removeBlock(mapCopy, visited);
			setBlock(mapCopy);
			shoot(n+1, mapCopy);
		}
		// 숫자 조합을 모두 고름 -> 실제로 블럭이 어떤 순서로 사라지는지 시뮬레이션
		
	}
	static void printMap(int[][] map) {
		for(int i=0; i<H; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	}
	static int countBlock(int[][] map) {
		int count = 0;
		for(int i=0; i<H; i++) {
			for(int j=0; j<W; j++) {
				if(map[i][j] != 0) count++;
			}
		}
		return count;
	}
	static void removeBlock(int[][] map, boolean[][] visited) {
		for(int i=0; i<H; i++) {
			for(int j=0; j<W; j++) {
				if(visited[i][j]) {
					map[i][j] = 0;
				}
			}
		}
	}
	static void setBlock(int[][] map) {
		stack.clear();
		for(int i=0; i<W; i++) {
			stack.clear();
			for(int j=0; j<H; j++) {
				int num = map[j][i];
				if(num != 0) {
					stack.add(num);
				}
			}
			for(int j=H-1; j>=0; j--) {
				map[j][i] = stack.size() == 0 ? 0 : stack.pop();
			}
			
		}
	}
	static boolean bound(int x, int y) {
		return x>=0&&y>=0&&x<W&&y<H;
	}
}
