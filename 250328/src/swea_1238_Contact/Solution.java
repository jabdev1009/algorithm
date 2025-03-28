package swea_1238_Contact;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
	
	static int N;
	static int start;
	static int maxTime;
	static int maxNode;
	static Map<Integer, List<Integer>> map;
	static Set<Integer> visited;
	
	static Queue<int[]> q;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int T = 10;
		for (int tc = 1; tc <= T; tc++, sb.append("\n")) {
			sb.append('#').append(tc).append(' ');
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			start = Integer.parseInt(st.nextToken());
			maxTime = Integer.MIN_VALUE;
			maxNode = Integer.MIN_VALUE;
			map = new HashMap<>();
			
			st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) {
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				if(map.get(s) == null) {
					map.put(s, new ArrayList<>());
				}
				List list = map.get(s);
				list.add(e);
			}// 다 넣어 줌
			bfs(start,0);
			sb.append(maxNode);
		}
		System.out.println(sb);
	}
	static void bfs(int start, int time) {
		q = new LinkedList<>();
		visited = new HashSet<>();
		visited.add(start);
		q.add(new int[] {start, time});
		while(!q.isEmpty()) {
			int[] info = q.poll();
			int node = info[0];
			int now = info[1];
			if(now > maxTime) {
				maxTime = now;
				maxNode = node;
			} else if(now == maxTime) {
				maxNode = Math.max(node,maxNode);
			}
			List<Integer> list = map.get(node);
			if(list != null) {
				for(int i=0; i<list.size(); i++) {
					int next = list.get(i);
					if(visited.add(next)) {
						q.add(new int[] {next, now+1});
					}
				}
			}
		}
	}
}