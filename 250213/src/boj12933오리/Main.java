package boj12933오리;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		List<Integer> list = new ArrayList<>();
		
		int now = 0;
		Set<Integer> duck = new HashSet<>();
		int result = 0;
		loop:
		for(int i=0; i<str.length(); i++) {
			char c = str.charAt(i);
			if(c == 'q') {
				list.add(now, 1);
				now++;
			} else if(c == 'u') {
				if(now == 0) {
					result = -1;
					break loop;
				}
				for(int j=now-1; j>=0; j--) {
					if(list.get(j) == 1) {
						list.set(j, 2);
						break;
					} 
					if(j == 0 && list.get(j) != 1) {
						result = -1;
						break loop;
					}
				}
			} else if(c == 'a') {
				if(now == 0) {
					result = -1;
					break loop;
				}
				for(int j=now-1; j>=0; j--) {
					if(list.get(j) == 2) {
						list.set(j, 3);
						break;
					} 
					if(j == 0 && list.get(j) != 2) {
						result = -1;
						break loop;
					}
				}
			} else if(c == 'c') {
				if(now == 0) {
					result = -1;
					break loop;
				}
				for(int j=now-1; j>=0; j--) {
					if(list.get(j) == 3) {
						list.set(j, 4);
						break;
					} 
					if(j == 0 && list.get(j) != 3) {
						result = -1;
						break loop;
					}
				}
			} else if(c == 'k') {
				if(now == 0) {
					result = -1;
					break loop;
				}
				for(int j=now-1; j>=0; j--) {
					if(list.get(j) == 4) {
						duck.add(j);
						list.remove(j);
						now--;
						break;
					} 
					if(j == 0 && list.get(j) != 4) {
						result = -1;
						break loop;
					}
				}
			}
		}
		if(result == -1 || list.size() > 0) {
			System.out.println(-1);
		} else {
			System.out.println(duck.size());
		}
	}
}
