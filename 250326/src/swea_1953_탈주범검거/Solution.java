package swea_1953_탈주범검거;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	// 상하좌우를 나타내는 상수
	static final int UP = 0;
	static final int DOWN = 1;
	static final int LEFT = 2;
	static final int RIGHT = 3;
	// 상하좌우로 이동할 때 이동할 수 있는 터널 종류
	static final int[][] PARTS = {
		{1,2,5,6}, {1,2,4,7}, {1,3,4,5}, {1,3,6,7}
	};
	// 터널 타입에 따라 이동할 수 있는 x방향
	static final int[][] DXS = {
		{},{0,0,-1,1}, {0,0}, {-1,1}, {0,1}, {0,1}, {-1,0}, {-1,0}
	};
	// 터널 타입에 따라 이동할 수 있는 y방향
	static final int[][] DYS = {
		{},{-1,1,0,0}, {-1,1}, {0,0}, {-1,0}, {1,0}, {0,1}, {0,-1}
	};
	
	static int N;
	static int M;
	static int entryX;
	static int entryY;
	static int L;
	
	static int[][] map;
	static boolean[][] visited;
	static Queue<int[]> q;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = null;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<=T; tc++) {
			sb = new StringBuilder();
			// 출력 기본값
			sb.append('#').append(tc).append(' ');
			st = new StringTokenizer(br.readLine());
			// 지도크기, 입구, 시간 초기화
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			entryY = Integer.parseInt(st.nextToken());
			entryX = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			
			map = new int[N][M];
			visited = new boolean[N][M];
			// 지도 정보 초기화
			for(int i=0; i<N; i++) {
				String[] arr = br.readLine().split(" ");
				for(int j=0; j<M; j++) {
					map[i][j] = Integer.parseInt(arr[j]);
				}
			}
			// 탈주
			run(entryX,entryY,1);
			
			int count = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(visited[i][j]) {
						count++;
					}
				}
			}
			sb.append(count);
			System.out.println(sb);
		}
	}
	// 입구로 들어가서 시간이 다 될 때까지 이동한다.
	static void run(int x, int y, int time) {
		q = new LinkedList<>();
		// 입구 정보를 넣어주고 방문처리
		q.add(new int[] {x,y,time}); 
		visited[y][x] = true;
		// 큐가 빌 때까지 = 시간이 다 될 때까지
		while(!q.isEmpty()) {
			// 위치와 시간이 담긴 배열을 꺼내서
			int[] info = q.poll();
			// 배열의 값들로 변수들 초기화 시켜줌
			x = info[0];
			y = info[1];
			time = info[2];
			// 검사하는 위치의 터널 타입
			int type = map[y][x];
			
			// 터널 타입에 맞는 이동 방향을 가져온다.
			int[] dx = DXS[type];
			int[] dy = DYS[type];
			// 이동 가능한 방향 수 만큼 검사
			for(int i=0; i<dx.length; i++) {
				// 이동하게 되는 좌표값을 만들어주고
				int xx = x+dx[i];
				int yy = y+dy[i];
				// 지도 범위 안인지, 방문한적 있는지, 가려고 하는 좌표에 있는 터널이 연결되어 있는지, 제한시간 이내인지 검사
				if(bound(xx,yy) && !visited[yy][xx] && chk(xx,yy,dx[i],dy[i]) && time+1 <=L) {
					// 조건문 통과하면 이동할 수 있는 곳 = 방문처리
					visited[yy][xx] = true;
					// 이동할 곳의 좌표, 시간 정보를 배열에 담아 큐에 넣어준다.
					q.add(new int[] {xx,yy,time+1});
				}
			}
			
		}
	}
	// 입력받은 좌표에 이동가능한 터널이 있는지 확인하기 위한 메서드 
	static boolean chk(int x, int y, int dx, int dy) {
		// 이동방향을 결정한다 dx-dy조합에 따라 결정됨
		int direc = dx == 0 ? (dy == 1 ? DOWN: UP):(dx == -1? LEFT : RIGHT) ;
		// 해당 방향으로 이동가능한 터널리스트
		int[] list = PARTS[direc]; 
		// 리스트에 해당하는 터널이 하나라도 있으면 이동 가능
		for(int i=0; i<list.length; i++) {
			if(list[i] == map[y][x]) {
				return true;
			}
		}
		// 리스트에 있는 터널 종류가 아니면 이동 불가
		return false;
	}
	// 지도범위 이내의 좌표인지 확인하기 위한 메서드
	static boolean bound(int x, int y) {
		return x>=0&&x<M&&y>=0&&y<N;
	}
}
