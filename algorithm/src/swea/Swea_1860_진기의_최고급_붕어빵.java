package swea;

import java.util.Arrays;
import java.util.Scanner;

public class Swea_1860_진기의_최고급_붕어빵 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case=1; test_case<=T; test_case++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int k = sc.nextInt();
			
			int[] customers = new int[n];
			for(int i=0; i<n; i++) {
				customers[i] = sc.nextInt();
			}
			Arrays.sort(customers);
			int currBung = 0;
			int lastCustomer = customers[customers.length-1];
			
			
			String result = "Possible";
			loop:
			for(int i=0; i<=lastCustomer; i++) {
				if(i != 0 && i % m == 0) {
					currBung += k;
				}
				for(int j=0; j<customers.length; j++) {
					if(customers[j] == i) {
						currBung--;
						if(currBung<0) {
							result = "Impossible";
							break loop;
						}
					} 
				}
			}
			System.out.println("#"+test_case+" "+result);
		}
	}
}
