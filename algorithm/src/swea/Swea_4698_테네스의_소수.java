package swea;

import java.util.Scanner;

public class Swea_4698_테네스의_소수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		// 에라토스테네스의 체
		/*
		 * 특정 범위에서 소수를 찾으려고 할 때
		 * 가장 작은 소수를 찾고 해당 소수를 제외한 배수들을 지워가면서 소수 판별
		 */
		int[] arr = new int[1000001]; // 구하려는 범위에 해당하는 배열을 만들고
		for(int i=2; i<arr.length; i++) {
			// 만들어진 배열을 해당 idx로 채워줌
			arr[i] = i; 
		}
		for(int i=2; i<arr.length; i++) {
			if(arr[i] == 0) {
				continue;
			}
			// 전체를 순회하면서 현재 idx의 배수에 해당하는 idx에 0을 넣어 소수가 아님을 표시
			// 자기자신을 제외한 배수부터 확인하기 위해 j = i가 아니라 j = i+i
			// 증감부를 j+=i로 설정하여 현재 idx의 배수에 대하여 검사하여 0을 넣어줌
			// 소수가 아닌 수에 0을 넣는것이 아니라 소수가 아닌 수에 해당 수를 넣어주면
			// line 15~18을 하지 않아도?
			for(int j = i+i; j<arr.length; j+=i) {
				arr[j] = 0;
			}
		}
		// 위에서 진행한 작업은 모든 테스트케이스에 동일하게 사용되기 때문에
		// 미리 작업을 해두고 케이스를 입력받아 진행
		for(int test_case=1; test_case<=T; test_case++) {
			int like = sc.nextInt();
			int start = sc.nextInt();
			int end = sc.nextInt();
			
			
			int count = 0;
			for(int i=start; i<=end; i++) {
				if(arr[i] == 0) {
					continue;
				}
				String tmp = String.valueOf(arr[i]);
				// i가 소수이고 좋아하는 숫자가 포함되어 있는지
				if(tmp.contains(String.valueOf(like))) {
					count++;
				}
			}
			System.out.println("#"+test_case+" "+count);
		}
	}
//	public static boolean isPrime(int i) {
//		int end = (int)Math.sqrt(i);
//		for(int k=2; k<=end; k++) {
//			if(i % k == 0) {
//				return false;
//			}
//		}
//		return true;
//	}
}
