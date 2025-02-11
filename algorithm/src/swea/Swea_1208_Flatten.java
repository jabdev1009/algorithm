package swea;

import java.util.Arrays;
import java.util.Scanner;

public class Swea_1208_Flatten {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;
		for(int tc = 1; tc<=T; tc++) {
			int n = sc.nextInt();
			int[] arr = new int[100];
			for(int i=0; i<100; i++) {
				arr[i] = sc.nextInt();
			}
					
			Arrays.sort(arr);	
			
			int min = arr[0]; 
			int max = arr[99];
			for(int i=0; i<n; i++) {
				min = arr[0];
				max = arr[99];
				if(max - min > 1) {
					arr[0]++;
					arr[99]--;
					Arrays.sort(arr);
				} else {
					break;
				}
			}
			min = arr[0];
			max = arr[99];
			System.out.println("#"+tc+" " + (max - min));
		}
	}
}
