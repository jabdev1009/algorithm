package swea_3289_서로소집합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int n;
	static int m;
	
	static int[] p;
	static int[] rank;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++, sb.append("\n")) {
			sb.append('#').append(tc).append(' ');
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			p = new int[n+1];
			rank = new int[n+1];
			for(int i=0; i<=n; i++) {
				p[i] = i;
			}
			
			for(int i=0; i<m; i++) {
				st = new StringTokenizer(br.readLine());
				int c = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				
				if(c == 0) {
					union(s,e);
				} else {
					sb.append(find(s) == find(e) ? 1 : 0);
				}
			}
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
