package swea;

import java.util.Scanner;

public class Swea_1493_수의_새로운_연산 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 1; test_case<=T; test_case++) {
			int result = 0;
			int p = sc.nextInt();
			int q = sc.nextInt();
			
			int x = 0;
			int y = 0;
			
			int minus = 1;
			
			while(true) {
				if(p-minus <= 0) {
					break;
				}
				p = p - minus;
				minus++;
			}
			x += p;
			y += minus + 1 - p;
			
			minus = 1;
			while(true) {
				if(q-minus <=0) {
					break;
				}
				q = q - minus;
				minus++;
			}
			x += q;
			y += minus + 1 - q;
			
			int tmp = x + y -2;
			int sum = 0;
			for(int i=1; i<=tmp; i++) {
				sum +=i;
			}
			result = sum + x;
			
			System.out.println("#"+test_case+" "+result);
		}
	}
}
