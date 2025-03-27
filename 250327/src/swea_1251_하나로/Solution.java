package swea_1251_하나로;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	
	static int N;
	static int[] p;
	static int[] rank;
	static int[] xx;
	static int[] yy;
	static double E;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		PriorityQueue<double[]> pq = new PriorityQueue<>(new Comparator<double[]>() {
			@Override
			public int compare(double[] o1, double[] o2) {
				return o1[2]-o2[2] > 0 ? 1: -1;
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
			
			for(int i=0; i<N-1; i++) {
				for(int j=i+1; j<N; j++) {
					double d = Math.pow(Math.abs(xx[i] - xx[j]), 2) + Math.pow(Math.abs(yy[i] - yy[j]), 2);
					pq.add(new double[] {i, j, d});
				}
			}
			
			double sum = 0;
			int count = 0;
			while(!pq.isEmpty()) {
				double[] info = pq.poll();
				int x = (int)info[0];
				int y = (int)info[1];
				int px = find(x);
				int py = find(y);
				if(px != py) {
					union(px, py);
					sum += info[2];
					count++;
				}
				if(count == N-1) {
					break;
				}
			}
			sb.append(Math.round(E*sum));
		}
		System.out.print(sb);
	}
	static int find(int x) {
		if(x != p[x]) {
			p[x] = find(p[x]);
		}
		return p[x];
	}
	static void union(int x, int y) {
		int px = find(x);
		int py = find(y);
		
		if(px != py) {
			if(rank[px] > rank[py]) {
				p[py] = px;
			} else if(rank[px] < rank[py]) {
				p[px] = py;
			} else {
				p[py] = px;
				rank[px]++;
			}
		}
	}
}