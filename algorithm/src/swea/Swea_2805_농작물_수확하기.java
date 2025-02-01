package swea;

import java.util.Scanner;

public class Swea_2805_농작물_수확하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case=1; test_case<=T; test_case++) {
			int n = sc.nextInt();
			int middle = (n-1)/2;
			int sum = 0;
			for(int i=0; i<n; i++) {
				String str = sc.next();
				for(int j=0; j<n; j++) {
					int num = Character.getNumericValue(str.charAt(j));
					if(
						Math.abs(i-middle) + Math.abs(j-middle) <= middle
					) {
						sum += num;
					}
				}
			}
			System.out.println("#"+test_case+" "+sum);
		}
	}
}
