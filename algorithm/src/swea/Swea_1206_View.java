package swea;

import java.util.Scanner;

public class Swea_1206_View {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 3;
		for(int tc=1; tc<=T; tc++) {
			// 건물 수
			int n = sc.nextInt();
			// 건물들의 높이를 받을 배열
			int[] arr = new int[n];
			for(int i=0; i<arr.length; i++) {
				arr[i] = sc.nextInt();
			}
			// 조망권 검사를 위해 검사 해야하는 범위(왼쪽, 오른쪽 2개씩)
			int[] d = {-1,1,-2,2};
			// 전체 조망권
			int sum = 0;
			for(int i=0; i<arr.length; i++) {
				// i 위치 건물 근처 조망권 검사 대상 건물 중 가장 높은 건물 높이
				int max = 0;
				for(int j=0; j<d.length; j++) {
					// 검사를 진행 할 건물의 인덱스
					int idx = i + d[j];
					// 인덱스가 범위내에 있고, 해당 인덱스에 건물이 있고 최대높이보다 크면
					if(idx < n && idx >= 0 && arr[idx] != 0 && arr[idx] > max ) {
						// max 갈아줌
						max = arr[idx];
					}
				}
				// i위치의 건물 높이가 주변에 있는 다른 건물들 보다 높으면
				if(arr[i] - max > 0) {
					// 전체 조망권에 현재 건물의 조망권을 더해줌
					sum += (arr[i] - max);
				}
			}
			System.out.println("#"+tc+" "+sum);
		}
	}
}
