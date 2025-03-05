import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	// 입구에서 출발하고 각 방의 연결 정보는 입력받아서
	// 입구에서 시작하는 bfs로 거리의 합이 최대가 되면 출력
	static int n;
	static ArrayList<long[]>[] map;
	static boolean[] visited;
	static long max;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new ArrayList[n+1];
		for(int i=0; i<n+1; i++) {
			map[i] = new ArrayList<>();
		}
		visited = new boolean[n+1];
		
		for(int i=0; i<n-1; i++) {
			int node1 = sc.nextInt();
			int node2 = sc.nextInt();
			long d = sc.nextInt();
			map[node1].add(new long[] {node2, d});
			map[node2].add(new long[] {node1, d});
		}
		
		Queue<long[]> q = new LinkedList<>();
		visited[1] = true;
		
		q.add(new long[] {1,0});
		
		while(!q.isEmpty()) {
			long[] info = q.poll();
			long node = info[0];
			long d = info[1];
			if(d > max) {
				max = d;
			}
			List<long[]> list = map[(int)node];
			for(int i=0; i<list.size(); i++) {
				long[] next = list.get(i);
				long xx = next[0];
				long dd = next[1];
				if(!visited[(int)xx]) {
					visited[(int)xx] = true;
					q.add(new long[] {xx, d + dd});
				}
			}
		}
		System.out.println(max);
	}
}
