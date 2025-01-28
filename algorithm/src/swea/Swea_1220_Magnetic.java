package swea;

import java.util.Scanner;

public class Swea_1220_Magnetic {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int test_case=0; test_case<10; test_case++) {
			int[][] arr = new int[100][100];
			int n = sc.nextInt();
			for(int j=0; j<100; j++) {
				for(int k=0; k<100; k++) {
					arr[j][k] = sc.nextInt();
				}
			}
			// 1이 몇번을 나오던 2가 나오면 +1
			// 1-2의 순서쌍이 몇번 나오는지 순회
			int count = 0;
			for(int j=0; j<100; j++) {
				boolean flag = false;
				for(int k=0; k<100; k++) {
					if(arr[k][j] == 1) {
						flag = true;
					} else if(arr[k][j] == 2){
						if(flag) {
							count++;
							flag = false;
						}
					}
				}
			}
			
			System.out.println("#"+(test_case+1)+" "+count);
		}
	}
}
