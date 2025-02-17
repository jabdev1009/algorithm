package swea;

import java.util.Scanner;

public class Swea_3499_퍼펙트셔플 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			// 셔플할 문자의 수
			int n = sc.nextInt();
			// 입력받은 문자열을
			String tmp = sc.nextLine();
			// 띄어쓰기를 기준으로 짤라서 배열에 담아줌
			String[] arr = sc.nextLine().split(" ");
			System.out.print("#"+tc+" ");
			// 짝수면
			if(n % 2 == 0) {
				// 나눴을때 중간
				int half = n / 2;
				for(int i=0; i<half; i++) {
					// 배열에 담아준 문자열에서 앞에서 1, 중간이후에서 1
					System.out.print(arr[i] +" "+ arr[i+half]+" ");
				}
			} else {
				// 나눴을 때 중간
				int half = (n-1)/2;
				// 첫번째 문자가 먼저 나오고
				System.out.print(arr[0]+" ");
				for(int i=1; i<=half;i++) {
					// 배열에 담아준 문자열에서 중간이후에서 1, 앞에서 1
					System.out.print(arr[i+half] + " " + arr[i]+" ");
				}
			}
			System.out.println();
		}
	}
}
