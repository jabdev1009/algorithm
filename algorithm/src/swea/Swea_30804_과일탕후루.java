package swea;

import java.util.Scanner;

public class Swea_30804_과일탕후루 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		int lIdx = 0;
		int rIdx = 0;
		
		
		if(n % 2 == 0) {
			rIdx = lIdx = (n-1)/2;
		} else {
			lIdx = ((n-1)/2) -1;
			rIdx = (n-1)/2;
		}
		
		int lFruit = arr[lIdx];
		int rFruit = arr[rIdx];
		
		boolean chk = true;
		
		while(true) {
			// 왼쪽과일 오른쪽과일이 같을때
			// lIdx-- 이후 왼쪽과일 검사해서 같으면 아무고토 안하고 다르면 왼쪽과일 바꿔줌
			// rIdx++ 이후 오른쪽과일 검사해서 같으면 아무고토 안하고 다르면 오른쪽과일 바꿔줌
			// 양쪽다 검사했는데 양쪽 다 다르면, 왼쪽으로 하나 
			if(lFruit == rFruit) {
			} else {
			// 왼쪽과일 오른쪽과일이 다를 때
			}
		}
	}
}
