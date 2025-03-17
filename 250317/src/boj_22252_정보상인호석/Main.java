package boj_22252_정보상인호석;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static Map<String, PriorityQueue<Integer>> map;
	static PriorityQueue<Integer> queue;
	static long price;
	
	static int cmd;
	static String name;
	static int num;
	static int size;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int Q = Integer.parseInt(st.nextToken());
		
		map = new HashMap<>();
		
		for(int i=0; i<Q; i++) {
			st = new StringTokenizer(br.readLine());
			cmd = Integer.parseInt(st.nextToken());
			name = st.nextToken();
			num = Integer.parseInt(st.nextToken());
			
			if(cmd == 1) {
				if(!map.containsKey(name)) {
					map.put(name, new PriorityQueue<>(Collections.reverseOrder()));
				} 
				for(int j=0; j<num; j++) {
					map.get(name).add(Integer.parseInt(st.nextToken()));
				}
			} else {
				if(map.containsKey(name)) {
					queue = map.get(name); 
					size = queue.size();
					
					if(size >= num) {
						for(int j=0; j<num; j++) {
							price += queue.poll();
						}
					} else {
						while(!queue.isEmpty()) {
							price += queue.poll();
						}
					}
				}
			}
//			if (cmd == 1) {
//                map.putIfAbsent(name, new PriorityQueue<>(Collections.reverseOrder()));
//                PriorityQueue<Integer> queue = map.get(name);
//                for (int j = 0; j < num; j++) {
//                    queue.add(Integer.parseInt(st.nextToken()));
//                }
//            } else {
//                PriorityQueue<Integer> queue = map.getOrDefault(name, new PriorityQueue<>());
//                for (int j = 0; j < Math.min(queue.size(), num); j++) {
//                    price += queue.poll();
//                }
//            }
		}
		System.out.println(price);
	}
}
