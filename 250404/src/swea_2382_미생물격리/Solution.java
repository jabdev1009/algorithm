package swea_2382_미생물격리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static class Mini {
		int size, dir;
		boolean isMoved;
		public Mini(int size, int dir, boolean isMoved) {
			this.size = size;
			this.dir = dir;
			this.isMoved = isMoved;
		}
		@Override
		public String toString() {
			return "Mini [size=" + size + "]";
		}
		
	}
	
	static int N, M, K;
	static List<Mini>[][] map;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++, sb.append('\n')) {
			sb.append('#').append(tc).append(' ');
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			map = new ArrayList[N][N];
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					map[i][j] = new ArrayList<>();
				}
			}
			
			for(int i=0; i<K; i++) {
				st = new StringTokenizer(br.readLine());
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				int size = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken())-1;
				map[y][x].add(new Mini(size,d,false));
			}
			
			while(M-->0) {
				move();
				setStatus();
			}
			
			sb.append(getSizeSum());
		}
		System.out.println(sb.toString());
	}
	static void move() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				List<Mini> list = map[i][j]; 
				if(list.size() != 0) {
					for(int k=list.size()-1; k>=0; k--) {
						Mini m = list.get(k);
						if(!m.isMoved) {
							int nx = j + dx[m.dir];
							int ny = i + dy[m.dir];
							if(!bound(nx, ny)) {
								m.dir = m.dir%2 == 0 ? m.dir+1 : m.dir-1;
								nx = j + dx[m.dir];
								ny = i + dy[m.dir];
							}
							m.isMoved = true;
							map[ny][nx].add(m);
							map[i][j].remove(k);
						}
					}
				}
			}
		}
	}
	static void setStatus() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				List<Mini> list = map[i][j];
				if(list.size() == 0) continue;
				if(list.size() == 1) {
					Mini m = list.get(0);
					if(edge(j, i)) {
						m.size /= 2;
					}
					m.isMoved = false;
				} else {
					int nd = -1;
					int size = 0;
					int max = 0;
					for(int k=0; k<list.size(); k++) {
						size += list.get(k).size;
						if(list.get(k).size > max) {
							max = list.get(k).size;
							nd = list.get(k).dir;
						}
					}
					map[i][j].clear();
					map[i][j].add(new Mini(size, nd, false));
				}
			}
		}
	}
	static void printMap() {
		for(int i=0; i<N; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		System.out.println("--------------------------------------------");
	}
	static int getSizeSum() {
		int sum = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				List<Mini> list = map[i][j];
				if(list.size() != 0) {
					for(int k=0; k<list.size(); k++) {
						sum += list.get(k).size;
					}
				}
			}
		}
		return sum;
	}
	static boolean edge(int x, int y) {
		return x == 0 || x == N-1 || y == 0 || y == N-1;
	}
	static boolean bound(int x,int y) {
		return x>=0&&y>=0&&x<N&&y<N;
	}
}
