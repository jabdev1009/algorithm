package swea;

import java.util.Scanner;

public class Swea_3499_퍼펙트셔플 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case=1; test_case<=T; test_case++) {
			int n = sc.nextInt();
			String tmp = sc.nextLine();
			String[] arr = sc.nextLine().split(" ");
			System.out.print("#"+test_case+" ");
			if(n % 2 == 0) {
				int half = n / 2;
				for(int i=0; i<half; i++) {
					System.out.print(arr[i] +" "+ arr[i+half]+" ");
				}
			} else {
				int half = (n-1)/2;
				System.out.print(arr[0]+" ");
				for(int i=1; i<=half;i++) {
					System.out.print(arr[i+half] + " " + arr[i]+" ");
				}
			}
			System.out.println();
		}
	}
}
