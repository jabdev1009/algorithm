import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	// 컴퓨터간 연결정보를 담을 리스트
	static ArrayList<ArrayList<Integer>> graph ;
	// 컴퓨터를 방문했는지 여부
	static boolean[] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 컴퓨터 수
		int pc = sc.nextInt();
		// 컴퓨터간 연결 정보 수
		int n = sc.nextInt();
		
		// 인덱스를 편리하게 사용하기 위해 pc +1
		visited = new boolean[pc+1];
		graph = new ArrayList<ArrayList<Integer>>();
		for(int i=0; i<pc+1; i++) {
			graph.add(new ArrayList<Integer>());
		}
		// 입력된 연결정보를 각각에 해당하는 컴퓨터에 담아줌
		for(int i=0; i<n; i++) {
			int node1 = sc.nextInt();
			int node2 = sc.nextInt();
			graph.get(node1).add(node2);
			graph.get(node2).add(node1);
		}
		
		// 1번 pc 방문처리 후
		visited[1] = true;
		// 1번에서 연결된 컴퓨터 탐색
		dfs(1);
		
		// 1번 컴퓨터를 제외한 컴퓨터에서 방문 처리 된 컴퓨터의 수
		int count = 0;
		for(int i=2; i<visited.length; i++) {
			if(visited[i]) {
				count++;
			}
		}
		System.out.println(count);
		
	}
	
	public static void dfs(int n) {
		for(int i=0; i<graph.get(n).size(); i++) {
			List<Integer> list = graph.get(n);
			for(int j=0; j<list.size(); j++) {
				int node = list.get(j);
				if(!visited[node]) {
					visited[node] = true;
					dfs(node);
				}
			}
		}
	}
}
