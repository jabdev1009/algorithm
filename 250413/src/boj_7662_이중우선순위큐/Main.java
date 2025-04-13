package boj_7662_이중우선순위큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		
		TreeMap<Integer, Integer> map;
		String cmd;
		int num;
		StringBuilder sb = new StringBuilder();
		for(int t = 0; t<T; t++, sb.append('\n')) {
			map = new TreeMap<>();
			int TT = Integer.parseInt(br.readLine());
			for(int tt=0; tt<TT; tt++) {
				st = new StringTokenizer(br.readLine());
				cmd = st.nextToken();
				num = Integer.parseInt(st.nextToken());
				
				if(cmd.equals("I")) {
					map.put(num, map.getOrDefault(num, 0)+1);
				} else {
					if(map.size() == 0) {
						continue;
					}
					int target;
					if(num == 1) {
						target = map.lastKey();
					} else {
						target = map.firstKey();
					}
					if(map.put(target, map.get(target)-1) == 1) {
						map.remove(target);
					}
				}
			}
			
			if(map.size() > 0) {
				sb.append(map.lastKey()).append(' ').append(map.firstKey());
			} else {
				sb.append("EMPTY");
			}
		}
		System.out.println(sb.toString());
	}
}
