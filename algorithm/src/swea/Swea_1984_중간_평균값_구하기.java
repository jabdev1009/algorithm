package swea;

import java.util.Arrays;
import java.util.Scanner;

public class Swea_1984_중간_평균값_구하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case=1; test_case<=T; test_case++) {
			int[] nums = new int[10];
			for(int i=0; i<nums.length; i++) {
				nums[i] = sc.nextInt();
			}
			Arrays.sort(nums);
			double sum = 0;
			for(int i=1; i<nums.length-1; i++) {
				sum += nums[i];
			}
			System.out.println("#"+test_case+" "+Math.round(sum/8));
		}
	}
}
