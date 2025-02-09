import java.util.ArrayList;
import java.util.Scanner;

public class Boj_1068_트리 {
	static int n;
	static ArrayList<ArrayList<Integer>> graph;
	static boolean[] visited;
	static int delete;
	static int count = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		graph = new ArrayList<ArrayList<Integer>>();
		for(int i=0; i<n; i++) {
			graph.add(new ArrayList<Integer>());
		}
		visited  = new boolean[n];
		
		int start = 0;
		for(int i=0; i<n; i++) {
			int num = sc.nextInt();
			if(num == -1) {
				start = i;
			} else {
				graph.get(num).add(i);
			}
		}
		delete = sc.nextInt();
		visited[delete] = true;
		
		dfs(start);
		System.out.println(count);
	}
	
	static void dfs(int start) {
		
		if(!visited[start]) {
			
			for(int i=0; i<graph.get(start).size(); i++) {
				int next = graph.get(start).get(i);
				if(!visited[next] && graph.get(next).size() == 0 || graph.get(start).size() == 1 && visited[next]) {
					// 리프
					count++;
					visited[next] = true;
				} else {
					if(!visited[next]) {
						dfs(next);
						visited[next] = true;
					}
				}
			}
		}
	}
}
