package boj_4386_별자리만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[] p, rank;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
				
		N = Integer.parseInt(br.readLine());
		double[][] xy = new double[N][2];
		p = new int[N];
		for(int i=0; i<N; i++) {
			p[i] = i;
		}
		rank = new int[N];
		
		PriorityQueue<double[]> pq = new PriorityQueue<>(new Comparator<double[]>() {
			@Override
			public int compare(double[] o1, double[] o2) {
				return o1[2]-o2[2] > 0 ? 1 : -1;
			}
		});
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			double x = Double.parseDouble(st.nextToken());
			double y = Double.parseDouble(st.nextToken());
			xy[i] = new double[] {x,y};
		}
		for(int i=0; i<N-1; i++) {
			for(int j=i+1; j<N; j++) {
				double d = Math.sqrt(Math.pow(Math.abs(xy[i][0]-xy[j][0]),2) + Math.pow(Math.abs(xy[i][1]-xy[j][1]),2));
				pq.add(new double[]{i, j, d});
			}
		}
		double cost = 0;
		int count = 0;
		while(true) {
			double[] info = pq.poll();
			int s = (int)info[0];
			int e = (int)info[1];
			double c = info[2];
			
			int ps = find(s);
			int pe = find(e);
			if(ps != pe) {
				union(ps, pe);
				cost+=c;
				count++;
			}
			
			if(count == N-1) {
				break;
			}
		}
		System.out.printf("%.9f",cost);
		
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
			if (rank[px] > rank[py]) {
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
/*
3
1.0 1.0
2.0 2.0
2.0 4.0
*/