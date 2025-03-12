package boj_15649_N과M1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int M;
	
	static int[] sel;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		sel = new int[M];
		
		sequence(0, 0);
	}
	static void sequence(int sidx, int visited) {
		if(sidx == M) {
			for(int i=0; i<sidx; i++) {
				System.out.print(sel[i]+" ");
			}
			System.out.println();
			return;
		}
		for(int i=1; i<=N; i++) {
			if((visited & 1<<(i-1)) > 0) {
				continue;
			}
			sel[sidx] = i;
			sequence(sidx+1, (visited|1<<(i-1)));
		}
	}
}
