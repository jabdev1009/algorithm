import java.util.Scanner;

public class Boj_14696_딱지놀이 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int round = sc.nextInt();
		// arrA : {0,세모,네모,동그라미,별}
		// arrB : {0,세모,네모,동그라미,별}
		// idx를 거꾸로 찾아가며 크기비교 -> 세모 이전에 크기차이가 나면 결과 출력 + break
		// 세모를 비교해서 갯수가 같으면 무승부
		for(int i=0; i<round; i++) {
			int a = sc.nextInt();
			int[] arrA = new int[5];
			for(int j=0; j<a; j++) {
				arrA[sc.nextInt()]++;
			}
			
			int b = sc.nextInt();
			int[] arrB = new int[5];
			for(int j=0; j<b; j++) {
				arrB[sc.nextInt()]++;
			}
			
			for(int j=4; j>0; j--) {
				if(arrA[j] > arrB[j]) {
					System.out.println("A");
					break;
				} else if(arrA[j] < arrB[j]) {
					System.out.println("B");
					break;
				} else if(j == 1 && arrA[j] == arrB[j]) {
					System.out.println("D");
				}
			}
		}
	}
}
