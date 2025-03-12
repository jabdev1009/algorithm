package boj_15654_N과M5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int[] sel;
	static int[] nums;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		sel = new int[M];
		nums = new int[N];
		sb = new StringBuilder();
		String[] arr = br.readLine().split(" ");
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(arr[i]);
		}
		
		Arrays.sort(nums);
		
		sequence(0, 0);
		System.out.println(sb);
	}
	static void sequence(int sidx, int visited) {
		if(sidx == M) {
			for(int i=0; i<sidx; i++) {
				sb.append(sel[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=0; i<N; i++) {
			if((visited & 1<<i) > 0) {
				continue;	
			}
			sel[sidx] = nums[i];
			sequence(sidx+1, (visited | 1<<i));
		}
	}
}
