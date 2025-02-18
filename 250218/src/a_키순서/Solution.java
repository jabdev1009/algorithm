package a_키순서;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
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
		Queue<Integer> queue = new LinkedList<>();
		visited[num] = true;
		queue.offer(num);
		
		while(!queue.isEmpty()) {
			int node = queue.poll();
			ArrayList<Integer> list = graphIn.get(node);
			int size = list.size();
			if(size > 0) {
				for(int i=0; i<size; i++) {
					int next = list.get(i);
					if(!visited[next]) {
						visited[next] = true;
						queue.offer(next);
					}
				}
			}
		}
	}
	static void outChk(int num) {
		Queue<Integer> queue = new LinkedList<>();
		visited[num] = true;
		queue.offer(num);
		
		while(!queue.isEmpty()) {
			int node = queue.poll();
			ArrayList<Integer> list = graphOut.get(node);
			int size = list.size();
			if(size > 0) {
				for(int i=0; i<size; i++) {
					int next = list.get(i);
					if(!visited[next]) {
						visited[next] = true;
						queue.offer(next);
					}
				}
			}
		}
	}
}
