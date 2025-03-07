package swea_6808_규영이와인영이의카드게임;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
	// 규영, 인영의 카드들
	static List<Integer> kyu;
	static List<Integer> in;
	
	static int kyuSum;
	static int inSum;
	
	// 총 이긴, 진 횟수
	static int win;
	static int lose;
	// 인영이 카드 사용여부 확인용 배열
	static boolean[] visited;
	static BufferedReader br;
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			kyu = new ArrayList<>();
			in = new ArrayList<>();
			visited = new boolean[9];
			win = 0;
			lose = 0;
			kyuSum = 0;
			inSum = 0;
			// 규영이 카드 정보 받아오고
			String[] tmp = br.readLine().split(" ");
			for(int i=0; i<9; i++) {
				
				int num = Integer.parseInt(tmp[i]);
				kyu.add(num);
				kyuSum += num;
			}
			// 나머지 숫자는 인영이가 가지고 있음
			for(int i=1; i<=18; i++) {
				if(!kyu.contains(i)) {
					inSum += i;
					in.add(i);
				}
			}
			// 슛
			game(0,0,0);
			
			System.out.println("#" + tc+ " "+ win + " " + lose);
			
		}
	}
	/**
	 * 
	 * @param a 몇판째인지
	 * @param w 규영이 총 점수
	 * @param l 인영이 총 점수
	 */
	static void game(int a, int w, int l) {
		if(Math.abs(w-l) > kyuSum + inSum) {
			if(w>l) {
				// 몇판째인지
				win+=factorial(9-a);
			} else {
				lose+=factorial(9-a);
			}
			return;
		}
		// 9판 다 했으면 이겼을 때, 졌을 때 총점 비교
		if(a == 9) {
			if(w>l) {
				win++;
			} else {
				lose++;
			}
			return;
		}
		// 매 판 인영이의 카드를 돌면서 사용하지 않았다면 해당 카드를 사용해서 승부
		for(int b=0; b<9; b++) {
			if(!visited[b]) {
				int k = kyu.get(a);
				int i = in.get(b);
				// 승부에 사용한 카드를 사용처리
				kyuSum -= k;
				inSum -= i;
				visited[b] = true;
				// 승부의 결과에 따라 카드의 합을 더해서 다음 판 진행
				if(k > i) {
					game(a+1, w+k+i, l);
				} else {
					game(a+1, w, l+k+i);
				}
				// 승부에 사용한 카드를 사용처리 철회 -> 다른 카드 썼을 때 확인
				kyuSum += k;
				inSum += i;
				visited[b] = false;
			}
		}
	}
	static int factorial(int i) {
		if(i == 0) {
			return 1;
		}
		return i * factorial(i-1);
	}
}
