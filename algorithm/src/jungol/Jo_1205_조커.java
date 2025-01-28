package jungol;

import java.util.Arrays;
import java.util.Scanner;

public class Jo_1205_조커 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] nums = new int[n];
		int countZoker = 0;
		// 조커의 수를 세고 배열에서 조커를 앞으로 몰아둠
		for(int i=0; i<n; i++) {
			nums[i] = sc.nextInt();
			if(nums[i] == 0) {
				countZoker++;
			}
		}
		Arrays.sort(nums);
		
		int straight = 0;
		int sum = 1;
		// 조커만 있는 경우 카드의 수만큼 스트레이트
		if(countZoker == n) {
			straight = n;
		} else {
			// 조커의 수를 idx로 하는 반복문
			for(int i=countZoker; i<n; i++) {
				int cnt = 0;
				for(int j=0; j<n; j++) {
					// 마지막 인덱스인 경우 남은 조커의 수를 합에 더하고 break
					if(i+j == n-1) {
						if(countZoker > cnt) {
							sum += (countZoker - cnt);
						}
						break;
					} else {
						// 다음 인덱스에 있는 숫자와의 차이를 구한 뒤
						// 차이보다 조커의 수가 적으면 남은 조커의 수를 합에 더하고 break
						int gaps = nums[i+j+1] - nums[i+j] -1;
						if(gaps > 0) {
							if(gaps > countZoker - cnt) {
								sum += (countZoker - cnt);
								break;
							} else {
								// 차이보다 조커의 수가 많으면 사용한 조커수에 차이를 더한 뒤
								// 차이를 더한 값이 조커 수보다 크면 break
								// 아니면 차이를 합에 더하고 1을 더해줌
								cnt += gaps;
								if(countZoker < cnt) {
									break;
								} else {
									sum += gaps;
									sum += 1;
								}
							}
						} else if(gaps == 0) {
							sum++;
						}
					}
				}
				if(sum > straight) {
					straight = sum;
				}
				sum  = 1;
			}
		}
		System.out.println(straight);
	}
}
