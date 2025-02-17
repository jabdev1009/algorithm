package swea_7102_준홍이의카드놀이;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			
			// 합의 수를 담아둘 배열, 합의 결과 -2에 해당하는 인덱스에 담아둘거임
			int[] result = new int[n+m-1];
			// 합의 결과 -2에 해당하는 인덱스에 담고
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					int sum = i+j;
					// 빈도+1
					result[sum]++;
				}
			}
			// 그중에 제일 많이 나오는 빈도
			int max = 0;
			for(int i=0; i<result.length; i++) {
				if(result[i] > max) {
					max = result[i];
				}
			}
			
			System.out.print("#"+tc+" ");
			// 해당 빈도에 해당하면
			for(int i=0; i<result.length; i++) {
				if(result[i] == max) {
					// 인덱스 -2해둔 결과니까 현재 인덱스에 +2
					System.out.print((i+2)+" ");
				}
			}
			System.out.println();
		}
	}
}
