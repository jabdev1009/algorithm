package boj_6497_전력난;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static int m, n, pSum, newPSum;
	static int[] p, rank;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		while(true) {
			st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			
			if(m == 0 && n == 0) {
				break;
			}
			
			p = new int[m];
			rank = new int[m];
			
			for(int i=0; i<m; i++) {
				p[i] = i;
			}
			
			PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[2]-o2[2];
				}
			}); 
			pSum = 0;
			newPSum = 0;
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				int price = Integer.parseInt(st.nextToken());
				pSum += price;
				pq.add(new int[] {s,e,price});
			}
			
			while(!pq.isEmpty()) {
				int[] info = pq.poll();
				int s = info[0];
				int e = info[1];
				int p = info[2];
				
				int ps = find(s);
				int pe = find(e);
				
				if(ps != pe) {
					union(s, e);
					newPSum += p;
				}
			}
			sb.append(pSum - newPSum).append('\n');
		}
		System.out.println(sb.toString());
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
