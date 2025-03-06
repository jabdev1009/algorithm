package swea_보물상자;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int n = sc.nextInt();
			int len = n/4;
			int k = sc.nextInt();
			String str = sc.next();
			int[] nums = new int[n];
			for(int i=0; i<n; i++) {
				char c = str.charAt(i);
				if(c == 'A') {
					nums[i] = 10;
				} else if(c == 'B') {
					nums[i] = 11;
				} else if(c == 'C') {
					nums[i] = 12;
				} else if(c == 'D') {
					nums[i] = 13;
				} else if(c == 'E') {
					nums[i] = 14;
				} else if(c == 'F') {
					nums[i] = 15;
				} else {
					nums[i] = Character.getNumericValue(c);
				}
			}
			Set<Integer> set = new HashSet<>();
			for(int i=0; i<n; i++) {
				// 비밀번호의 길이만큼 16진수로 변환
				int num = 0;
				for(int j=0; j<len; j++) {
					num += (nums[(i+j)%n])*Math.pow(16, len-1-j);
				}
				set.add(num);
			}
			Object[] arr = set.toArray(); 
			
			Arrays.sort(arr);
			
			System.out.println("#" + tc+ " " +arr[arr.length-k]);
        }
    }
}