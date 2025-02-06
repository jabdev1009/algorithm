package swea;

import java.util.Arrays;
import java.util.Scanner;

public class Swea_1984_중간_평균값_구하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 테스트 케이스 수
		int T = sc.nextInt();
		for(int test_case=1; test_case<=T; test_case++) {
			// 입력값 담아둘거야
			int[] nums = new int[10];
			for(int i=0; i<nums.length; i++) {
				nums[i] = sc.nextInt();
			}
			// 오름차순으로 줄세워
			Arrays.sort(nums);
			double sum = 0;
			// 인덱스 조절해서 시작, 끝인덱스는 안더할게
			for(int i=1; i<nums.length-1; i++) {
				sum += nums[i];
			}
			// 8로 나눈거 소수점 첫째자리 반올림해서 출력 
			System.out.println("#"+test_case+" "+Math.round(sum/8));
		}
	}
}
