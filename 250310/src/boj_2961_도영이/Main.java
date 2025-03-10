package boj_2961_도영이;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int[][] list;
	static int N;
	static int min;
	static int total;
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		
		min = Integer.MAX_VALUE;
		N = Integer.parseInt(st.nextToken());
		list = new int[N][2];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			list[i][0] = Integer.parseInt(st.nextToken());
			list[i][1] = Integer.parseInt(st.nextToken());
		}
		
		total = (1<<N)-1;
		
		cook(1);
		System.out.println(min);
	}
	
	static void cook(int count) {
		if(count > total) {
			return;
		}
		
		int s = 1;
		int b = 0;
		// bit를 1씩 추가시켜 가면서 맛의 차이를 계산
		for(int i=0; i<N; i++) {
			if((count & (1<<i)) > 0) {
				s *= list[i][0];
				b += list[i][1];
			}
		}
		int nowMin = Math.abs(s-b);
		if(min>nowMin) {
			min = nowMin;
		}
		cook(++count);
	}
}
