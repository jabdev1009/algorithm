package boj_15649_N과M2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int M;
	static int[] sel;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		sel = new int[M];
		sb = new StringBuilder();
		sequence(1,0);
		System.out.println(sb);
	}
	static void sequence(int idx, int sidx) {
		if(sidx == M) {
			for(int i=0; i<M; i++) {
				sb.append(sel[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=idx; i<=N; i++) {
			sel[sidx] = i;
			sequence(i+1, sidx+1);
		}
	}
}
