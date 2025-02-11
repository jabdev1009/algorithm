import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int n;
	static int m;
	static int start;
	
	static ArrayList<ArrayList<Integer>> graph;
	static boolean[] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		start = sc.nextInt();
		
		graph = new ArrayList<ArrayList<Integer>>();
		for(int i=0; i<n+1; i++) {
			graph.add(new ArrayList<Integer>());
		}
		visited = new boolean[n+1];
		
		for(int i=0; i<m; i++) {
			int node1 = sc.nextInt();
			int node2 = sc.nextInt();
			graph.get(node1).add(node2);
			graph.get(node2).add(node1);
		}
		for(int i=0; i<n+1; i++) {
			Collections.sort(graph.get(i));
		}
		
		System.out.print(start+" ");
		visited[start] = true;
		dfs(start);
		
		System.out.println();
		visited = new boolean[n+1];
		visited[start] = true;
		bfs(start);
		
	}
	static void dfs(int start) {
		for(int i=0; i<graph.get(start).size(); i++) {
			List<Integer> list = graph.get(start);
			for(int j=0; j<list.size(); j++) {
				int next = list.get(j);
				if(!visited[next]) {
					System.out.print(next+" ");
					visited[next] = true;
					dfs(next);
				}
			}
		}
	}
	
	static void bfs(int start) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(start);
		while(!q.isEmpty()) {
			int now = q.poll();
			System.out.print(now+" ");
			
			for(int i=0; i<graph.get(now).size(); i++) {
				List<Integer> list = graph.get(now);
				for(int j=0; j<list.size(); j++) {
					int next = list.get(j);
					if(!visited[next]) {
						visited[next] = true;
						q.offer(next);
					}
				}
			}
			
		}
	}
}
