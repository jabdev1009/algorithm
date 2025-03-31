package swea_5643_키순서;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
	static ArrayList<ArrayList<Integer>> graphIn;
	static ArrayList<ArrayList<Integer>> graphOut;
	static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			graphIn = new ArrayList<ArrayList<Integer>>();
			graphOut = new ArrayList<ArrayList<Integer>>();
			for(int i=0; i<N+1; i++) {
				graphIn.add(new ArrayList<Integer>());
				graphOut.add(new ArrayList<Integer>());
			}
			for(int i=0; i<M; i++) {
				int node1 = sc.nextInt();
				int node2 = sc.nextInt();
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
