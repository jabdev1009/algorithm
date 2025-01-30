package swea;

import java.util.Scanner;

public class Swea_1218_괄호_짝짓기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int test_case = 1; test_case<=10; test_case++) {
			int n = sc.nextInt();
			String str = sc.next();
			int[] arr = new int[4];
			
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
