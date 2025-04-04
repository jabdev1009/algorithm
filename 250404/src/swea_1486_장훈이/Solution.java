package swea_1486_장훈이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int N, B, min;
	static int[] nums;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++, sb.append('\n')) {
			sb.append('#').append(tc).append(' ');
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken()); 
			B = Integer.parseInt(st.nextToken());
			min = Integer.MAX_VALUE;
			nums = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			
			comb(0,0);
			sb.append(min);
		}
		System.out.println(sb.toString());
	}
	
	static void comb(int idx, int sum) {
		if(sum >= B) {
			min = Math.min(min, sum-B);
			return;
		}
		
		for(int i=idx; i<N; i++) {
			sum += nums[i];
			comb(i+1, sum);
			sum -= nums[i];
		}
	}
}
