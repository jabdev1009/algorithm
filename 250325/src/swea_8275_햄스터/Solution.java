package swea_8275_햄스터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	
	static int N;
	static int X;
	static int M;
	static int l;
	static int r;
	static int s;
	// 검사해야할 조건 담아두는 리스트
	static List<int[]> condi;
	// 조건에 부합하는 쥐돌이 조합을 담아두는 pq
	static PriorityQueue<int[]> pq;
	// 햄스터가 가장 많을 때를 찾아두기 위한 변수
	static int max;
	// 쥐돌이 조합을 담아두는 배열
	static int[] sel;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = null;
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			sb = new StringBuilder();
			sb.append('#').append(tc).append(' ');
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			condi = new ArrayList<>();
			sel = new int[N];
			// 쥐돌이 조합 사전순으로 가장 앞선 것 -> 오름차순으로 가지고 있자
			pq = new PriorityQueue<>(new Comparator<int[]>(){
				@Override
				public int compare(int[] o1, int[] o2) {
					for(int i=0; i<o1.length; i++) {
						if(o1[i] != o2[i]) {
							return o1[i] - o2[i];
						}
					}
					return 0;
				}
			});
			// 쥐돌이 조합의 조건을 초기화 해준다.
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				l = Integer.parseInt(st.nextToken());
				r = Integer.parseInt(st.nextToken());
				s = Integer.parseInt(st.nextToken());
				
				condi.add(new int[] {l,r,s});
			}
			// 최대값 초기화 해두고
			max = Integer.MIN_VALUE;
			// 조합찾으러 가자
			comb(0);
			// 정렬된 조합중에 하나 꺼내서
			int[] result = pq.poll();
			// 없으면 배치가 불가능한 경우
			if(result == null) {
				sb.append(-1);
			} else {
				// 있으면 하나씩 꺼내서 붙여준다.
				for(int i=0; i<N; i++) {
					sb.append(result[i]).append(' ');
				}
			}
			System.out.println(sb);
		}
	}
	
	static void comb(int sidx) {
		// 쥐돌이 집 갯수만큼 조합 만들었을 때
		if(sidx == N) {
			// 조건 검사함
			for(int i=0; i<M; i++) {
				// 조건 하나 꺼내서
				int[] cArr = condi.get(i);
				int sum = 0;
				// 해당 조건의 범위 합을 구하고
				for(int ii=cArr[0]-1; ii<=cArr[1]-1; ii++) {
					sum+=sel[ii];
				}
				// 범위 합이 조건의 결과랑 다르면 불가능한 배치 -> 컷
				if(sum != cArr[2]) {
					return;
				}
			}
			// 모든 조건에 부합하는 쥐돌이 숫자 조합이면 여기까지 살아서 온다.
			// 쥐돌이가 가장 많은지, 가장 많다면 사전순으로 정렬되어 있는지 확인하고 return
			int sum = 0;
			// 쥐돌이 조합에 있는 숫자 다 더해서
			for(int i=0; i<N; i++) {
				sum+=sel[i];
			}
			// 해당 조합 복사해두고
			int[] copy = sel.clone();
			// 지금 조합의 쥐돌이 총합이 최대이면
			if(sum > max) {
				// pq비우고, 복사해둔 쥐돌이 조합 넣고, max값 초기화
				pq.clear();
				pq.offer(copy);
				max = sum;
			} else if(sum == max) {
				// max값이랑 같으면 pq에 넣어줌
				pq.offer(copy);
			}
			return;
		}
		// 쥐돌이 조합을 만들어나간다. 0마리부터 X마리까지
		for(int i=0; i<=X; i++) {
			sel[sidx] = i;
			comb(sidx+1);
		}
	}
}