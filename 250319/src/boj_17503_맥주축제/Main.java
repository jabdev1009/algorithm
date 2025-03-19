package boj_17503_맥주축제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int M;
	static int K;
	
	static int[] prefer;
	static int[] level;
	
	static int min;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		prefer = new int[K];
		level = new int[K];
		
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			prefer[i] = Integer.parseInt(st.nextToken());
			level[i] = Integer.parseInt(st.nextToken());
		}
		min = Integer.MAX_VALUE;
		
		
		
		System.out.println(min);
		
	}
}