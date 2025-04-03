package swea_5643_키순서;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
	static ArrayList<ArrayList<Integer>> graphIn;
	static ArrayList<ArrayList<Integer>> graphOut;
	static boolean[] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int M = Integer.parseInt(br.readLine());
			graphIn = new ArrayList<ArrayList<Integer>>();
			graphOut = new ArrayList<ArrayList<Integer>>();
			for(int i=0; i<N+1; i++) {
				graphIn.add(new ArrayList<Integer>());
				graphOut.add(new ArrayList<Integer>());
			}
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				int node1 = Integer.parseInt(st.nextToken());
				int node2 = Integer.parseInt(st.nextToken());
				graphIn.get(node1).add(node2);
				graphOut.get(node2).add(node1);
			}
			
			int count = 0;
			for(int i=1; i<=N; i++) {
				visited = new boolean[N+1];
				visited[i] = true;
				inChk(i);
				outChk(i);
				boolean flag = true;
				for(int j=1; j<=N; j++) {
					if(!visited[j]) {
						flag = false;
						break;
					}
				}
				if(flag) {
					count++;
				}
			}
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ").append(count);
			System.out.println(sb);
		}
	}
	static void inChk(int num) {
		for(int n : graphIn.get(num)) {
			if(!visited[n]) {
				visited[n] = true;
				inChk(n);
			}
		}
	}
	static void outChk(int num) {
		for(int n : graphOut.get(num)) {
			if(!visited[n]) {
				visited[n] = true;
				outChk(n);
			}
		}
	}
}
