package boj_16234_인구이동;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static class Country {
		int idx, population;

		public Country(int idx, int population) {
			super();
			this.idx = idx;
			this.population = population;
		}
	}
	
	static int N, bot, top;
	static Country[][] map;
	static boolean[][] visited;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		bot = Integer.parseInt(st.nextToken());
		top = Integer.parseInt(st.nextToken());
		
		map = new Country[N][N];
		visited = new boolean[N][N];
		int idx = 1;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = new Country(idx++,Integer.parseInt(st.nextToken()));
			}
		}
		int day = 0;
		boolean isReQ = false;
		while(day <= 2000) {
			// 이동이 필요한 나라가 있는지 확인, 있다면 해당 나라끼리 묶어 준다. -> union
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(!visited[i][j]) {
						if(bfs(j, i)) {
							isReQ = true;
						};
					}
				}
			}
			
			// 묶인 나라들 끼리 인구를 이동시킨다.
			
			
			
			day++;
		}
	}
	static boolean bfs(int x, int y) {
		Queue<Country> q = new LinkedList<>();
		q.add(map[y][x]);
//		while() {
//			
//		}
		return true;
		
	}
	static int find(int x) {
		return 0;
	}
	static void union(int x, int y) {
		
	}
}
