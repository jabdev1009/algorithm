package jungol;

import java.util.Arrays;
import java.util.Scanner;

public class Jo_1205_조커 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] nums = new int[n];
		int countZoker = 0;
		
		for(int i=0; i<n; i++) {
			nums[i] = sc.nextInt();
			if(nums[i] == 0) {
				countZoker++;
			}
		}
		Arrays.sort(nums);
		
		int straight = 0;
		int sum = 1;
		if(countZoker == n) {
			straight = n;
		} else {
			for(int i=countZoker; i<n; i++) {
				int cnt = 0;
				for(int j=0; j<n; j++) {
					if(i+j == n-1) {
						if(countZoker > cnt) {
							sum += (countZoker - cnt);
						}
						break;
					} else {
						int gaps = nums[i+j+1] - nums[i+j] -1;
						if(gaps > 0) {
							if(gaps > countZoker - cnt) {
								sum += (countZoker - cnt);
								break;
							} else {
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
