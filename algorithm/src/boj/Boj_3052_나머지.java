package boj;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Boj_3052_나머지 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Set result = new HashSet(); // 중복을 허용하지 않는 자료형
		
		for(int i=0; i<10; i++ ) {
			result.add(sc.nextInt() % 42);
		}
		System.out.println(result.size());
	}
}
