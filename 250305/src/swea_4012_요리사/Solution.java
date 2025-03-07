package swea_4012_요리사;

import java.util.Scanner;

public class Solution {
	static int n;
	static int r;
	// 맛 어쩌고 정보를 담아줄 2차원 배열
	static int[][] map;
	// true값으로 현재 만들어진 조합을 표시해줌, 초기값음 false
	static boolean[] visited;
	static int answer;	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb;
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");
			n = sc.nextInt();
			r = n/2;
			map = new int[n][n];
			visited = new boolean[n];
			answer = Integer.MAX_VALUE;
			// 위에서 값들을 만들어 주고, 맛 정보를 초기화 해준다.
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			// 조합 시작
			comb(0,0);
			sb.append(answer);
			System.out.println(sb);
		}
	}
	// 조합을 찾아주는 메서드
	static void comb(int idx, int cnt) {
		// 조합의 크기가 n/2가 되면 현재 최소 절대값과 현재 조합의 절대값을 비교
		if(cnt == r) {
			answer = Math.min(answer, getResult());
			return;
		}
		// 반복문을 돌면서 인덱스를 방문처리 해주고 재귀호출 -> 재귀 끝나고 나오면 방문처리 값을 돌려준다.
		for(int i=idx; i<n; i++) {
			visited[i] = true;
			comb(i+1, cnt+1);
			visited[i] = false;
		}
	}
	// 현재 조합에 선택된 항목과 아닌 항목들의 합을 구한 뒤 차의 절대값을 반환해주는 메서드
	static int getResult() {
		int picked=0;
		int left=0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				// 둘다 조합에 선택되었다면
				if(visited[i] && visited[j]) {
					// 그때의 맛 정보를 더해준다
					picked += map[i][j];
				} else if(!visited[i] && !visited[j]) {
					// 둘다 조합에 선택되지 않았다면
					// 비교대상 맛정보에 더해준다.
					left += map[i][j];
				}
			}
		}
		// 조합에 선택된 재료로 만들어진 음식들의 총맛 - 아닌 재료 음식 총맛 -> 절대값
		return Math.abs(picked - left);
	}
}
