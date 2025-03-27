package swea_7465_창용마을무리의개수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
	static int N,M;
	static int[] p,rank;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Set<Integer> root = new HashSet<>();;
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++, sb.append("\n")) {
			root.clear();
			sb.append('#').append(tc).append(' ');
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			p = new int[N+1];
			for(int i=1; i<=N; i++) {
				p[i] = i;
			}
			rank = new int[N+1];
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				
				union(s, e);
				
			}
			
			for(int i=1; i<=N; i++) {
				root.add(find(i));
			}
			sb.append(root.size());
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
