package swea_14555_공과잡초;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			String str = sc.next();
			Stack<Character> stack = new Stack<>();
			
			int count = 0;
			for(int i=0; i<str.length(); i++) {
				char c = str.charAt(i);
				if(c == '(') {
					count++;
				} else if(c == ')') {
					if(stack.size()>0) {
						char before = stack.peek();
						if(before != '(') {
							count++;
						}
					}
				}
				stack.push(c);
			}
			System.out.println("#"+tc+" "+count);
		}
	}
}
