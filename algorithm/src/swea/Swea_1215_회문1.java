package swea;

import java.util.Scanner;

public class Swea_1215_회문1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 2;
		for(int test_case=1; test_case<=T; test_case++) {
			int n = sc.nextInt();
			char[][] arr = new char[8][8];
			
			for(int i=0; i<8; i++) {
				String str = sc.next();
				for(int j=0; j<8; j++) {
					arr[i][j] = str.charAt(j);
				}
			}
			int count = 0;
			for(int i=0; i<8; i++) {
				for(int j=0; j<8; j++) {
					boolean flag = true; // 가로, 세로 검사에서 회문여부
					// 현재 idx에서 가로로 n칸에 해당하는 회문이 있는지 검사
					if(j <= 8-n) {
						for(int k=0; k<n/2; k++) {
							if(arr[i][j+k] != arr[i][j+(n-1)-k]) {
								flag = false;
								break;
							}
						}
						if(flag) {
							count++;
						}
						flag = true;
					}
					
					// 현재 idx에서 세로로 n칸에 해당하는 회문이 있는지 검사
					if(i <= 8-n) {
						for(int k=0; k<n/2; k++) {
							if(arr[i+k][j] != arr[i +(n-1) -k][j]) {
								flag = false;
								break;
							}
						}
						if(flag) {
							count++;
						}
					}
				}
			}
			System.out.println("#"+test_case+" "+count);
		}
	}
}
