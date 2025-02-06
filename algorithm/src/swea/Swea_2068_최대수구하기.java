package swea;

import java.util.Scanner;

public class Swea_2068_최대수구하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			// 최대값을 담을 변수
			int max = 0;
			for(int i=0; i<10; i++) {
				int tmp = sc.nextInt();
				// 현재 최대값과 입력받은 값 크기비교
				if(tmp > max) {
					// 입력받은게 크면 넣어줘
					max = tmp;
				}
			}
			System.out.println("#" + tc + " "+max);
		}
	}
}
