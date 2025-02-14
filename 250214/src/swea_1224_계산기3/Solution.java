package swea_1224_계산기3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Map<Character, Integer> priority = new HashMap<>();
		priority.put('(', 0);
		priority.put('+', 1);
		priority.put('-', 1);
		priority.put('*', 2);
		priority.put('/', 2);
		for(int tc=1; tc<=10; tc++) {
			int len = sc.nextInt();
			String str = sc.next();
			StringBuilder postfix = new StringBuilder();
			Stack<Character> op = new Stack<>();
			
			for(int i=0; i<len; i++) {
				char c = str.charAt(i);
				if(c == '(') {
					op.push(c);
				} else if(c == ')') {
					while(op.peek() != '(') {
						postfix.append(op.pop());
					}
					op.pop();
				} else if(c >= '0' && c <= '9') {
					postfix.append(c);
				} else {
					// 연산자
					if(op.isEmpty()) {
						op.push(c);
					} else {
						while(priority.get(op.peek()) >= priority.get(c) && !op.isEmpty()) {
							postfix.append(op.pop());
						}
						op.push(c);
					}
				}
			}
			while(!op.isEmpty()) {
				postfix.append(op.pop());
			}
			Stack<Integer> calc = new Stack<>();
			for(int i=0; i<postfix.length(); i++) {
				char c = postfix.charAt(i);
				if(c >= '0' && c <= '9') {
					calc.push(c-'0');
				} else {
					int b = calc.pop();
					int a = calc.pop();
					
					if(c == '+') {
						calc.push(a+b);
					} else if(c == '-') {
						calc.push(a-b);
					} else if(c == '*') {
						calc.push(a*b);
					} else if(c == '/') {
						calc.push(a/b);
					}
				}
			}
			System.out.println("#"+tc+" "+calc.pop());
		}
	}
}
