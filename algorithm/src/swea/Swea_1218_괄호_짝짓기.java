package swea;

import java.util.Scanner;

public class Swea_1218_괄호_짝짓기 {
	// 지금 문제에서는 짝이 맞는지를 확인
	// 괄호간 포함관계인지는 고려하지 않고 풀었음
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int test_case = 1; test_case<=10; test_case++) {
			int n = sc.nextInt();
			String str = sc.next();
			// 괄호의 종류가 4개, 각 인덱스 별로 하나씩 맵핑
			int[] arr = new int[4];
			
			// 전체 괄호들을 돌면서 
			// 여는 괄호면 맵핑된 인덱스에 +1, 닫는 괄호면 -1
			for(int i=0; i<n; i++) {
				char tmp = str.charAt(i); 
				if(tmp == '<') {
					arr[0]++;
				} else if(tmp == '>') {
					arr[0]--;
				} else if(tmp == '(') {
					arr[1]++;
				} else if(tmp == ')') {
					arr[1]--;
				} else if(tmp == '[') {
					arr[2]++;
				} else if(tmp == ']') {
					arr[2]--;
				} else if(tmp == '{') {
					arr[3]++;
				} else if(tmp == '}') {
					arr[3]--;
				}
			}
			int result = 1;
			// 배열에 0이 아닌 값이 있으면 여는, 닫는 괄호 중 뭐든 더 많았다는 거 
			for(int i=0; i<4; i++) {
				if(arr[i] != 0) {
					result = 0;
					break;
				}
			}
			System.out.println("#"+test_case+" "+result);
		}
	}
}
