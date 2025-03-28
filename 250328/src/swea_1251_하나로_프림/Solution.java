package swea_1251_하나로_프림;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	
	static int N;
	static int[] p;
	static int[] rank;
	static int[] xx;
	static int[] yy;
	static double E;
	static boolean[] visited;
	static List<double[]>[] graph;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		PriorityQueue<double[]> pq = new PriorityQueue<>(new Comparator<double[]>() {
			@Override
			public int compare(double[] o1, double[] o2) {
				return o1[1]-o2[1] > 0 ? 1: -1;
			}
		});
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++, sb.append("\n")) {
			pq.clear();
			sb.append('#').append(tc).append(' ');
			N = Integer.parseInt(br.readLine());
			xx = new int[N];
			yy = new int[N];
			p = new int[N];
			visited = new boolean[N];
					
			for(int i=0; i<N; i++) {
				p[i] = i;
			}
			rank = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				xx[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				yy[i] = Integer.parseInt(st.nextToken());
			}
			E = Double.parseDouble(br.readLine());
			
			graph = new ArrayList[N];
			for(int i=0; i<N; i++) {
				graph[i] = new ArrayList<>();
			}
			for(int i=0; i<N-1; i++) {
				for(int j=i+1; j<N; j++) {
					double d = Math.pow(Math.abs(xx[i] - xx[j]), 2) + Math.pow(Math.abs(yy[i] - yy[j]), 2);
					graph[i].add(new double[] {j, d});
					graph[j].add(new double[] {i, d});
				}
			}
			double sum = 0;
			int count = 1;
			visited[0] = true;
			pq.addAll(graph[0]);
			while(count < N) {
				double[] info = pq.poll();
				int node = (int)info[0];
				double cost = info[1];
				if(!visited[node]) {
					visited[node] = true;
					sum += cost;
					count++;
					pq.addAll(graph[node]);
				}
			}
			sb.append(Math.round(E*sum));
		}
		System.out.print(sb);
	}
}