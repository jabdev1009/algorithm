package boj_20040_사이클게임;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[] root;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		root = new int[n];
		for(int i=0; i<n; i++) {
			root[i] = i;
		}
		for(int i=1; i<=m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(findRoot(a) == findRoot(b)) {
				System.out.println(i);
				return;
			} else {
				unionRoot(a, b);
			}
		}
		System.out.println(0);
	}
	
	static int findRoot(int v) {
		if(root[v] == v) {
			return v;
		}
		return root[v] = findRoot(root[v]);
	}
	
	static void unionRoot(int a, int b) {
		int aa = findRoot(a);
		int bb = findRoot(b);
		
		if(aa < bb) {
			root[bb] = aa;
		} else {
			root[aa] = bb;
		}
	}
}