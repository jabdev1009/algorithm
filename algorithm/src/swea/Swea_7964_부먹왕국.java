package swea;

import java.util.Scanner;

public class Swea_7964_부먹왕국 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case=1; test_case<=T; test_case++) {
			int city = sc.nextInt();
			int limit = sc.nextInt();
			
			int countG = 0;
			int countD = 0;
			for(int i=0; i<city; i++) {
				int tmp = sc.nextInt();
				if(i == 0 && tmp == 0) {
					countG++;
				} else if(tmp == 0) {
					countD++;
					if(limit == countD) {
						countG++;
						countD = 0;
					}
				} else if(tmp == 1) {
					countD = 0;
				} else if(i == city-1 && tmp == 0) {
					countG++;
				}
				
			}
			System.out.println("#"+test_case+" "+countG);
			
		}
	}
}
