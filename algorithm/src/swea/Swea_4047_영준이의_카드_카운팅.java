package swea;

import java.util.Scanner;

public class Swea_4047_영준이의_카드_카운팅 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 1; test_case<=T; test_case++) {
			String str = sc.next();
			int[][] deck = new int[4][13];
			boolean flag = true;
			System.out.print("#"+test_case+" ");
			for(int i=0; i<str.length(); i++) {
				int pattern = 0;
				int num1 = 0;
				int num2 = 0;
				char tmp = str.charAt(i);
				if(tmp == 'S') {
					pattern = 0;
				} else if(tmp == 'D') {
					pattern = 1;
				} else if(tmp == 'H') {
					pattern = 2;
				} else {
					pattern = 3;
				}
				num1 = Character.getNumericValue(str.charAt(++i));
				num2 = 10*num1 + Character.getNumericValue(str.charAt(++i));
				if(deck[pattern][num2-1] != 0) {
					flag = false;
					break;
				} else {
					deck[pattern][num2-1]++;
				}
			}
			if(!flag) {
				System.out.println("ERROR");
			} else {
				for(int i=0; i<4; i++) {
					int count = 0;
					for(int j=0; j<13; j++) {
						if(deck[i][j] == 0) {
							count++;
						}
					}
					System.out.print(count+" ");
				}
				System.out.println();
			}
		}
	}
}
