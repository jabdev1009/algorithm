package swea_8931_제로;

import java.util.Scanner;
import java.util.Stack;

public class Solution2 {
	static Stack<Integer> stack;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int k = sc.nextInt();
			stack = new Stack<>();
			
			for(int i=0; i<k; i++) {
				int num = sc.nextInt();
				// 0이면 스택에 꺼낼놈이 보장
				if(num != 0) {
					// 0아니면 넣고
					stack.push(num);
				} else {
					// 0 이면 빼
					stack.pop();
				}
			}
			int sum = 0;
			// 사이즈 가변, 시작전에 받아둠
			int size = stack.size();
			for(int i=0; i<size; i++) {
				// 꺼낸 친구 더해줘
				sum += stack.pop();
			} 
			System.out.println("#"+tc+" "+sum);
		}
	}
}
