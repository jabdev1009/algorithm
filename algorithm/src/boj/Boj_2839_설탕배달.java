import java.util.Scanner;

public class Boj_2839_설탕배달 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int kg = sc.nextInt();
		
		int num = -1;
		
		// 5로 얼마나 나눌지, 3으로 얼마나 나눌지 모름
		// 5로 나눌수 있는만큼, 3으로 나눌 수 있는 만큼 돌면서 합이 입력받은 수가 되는 각각의 idx를 더한 합을 저장
		for(int i=0; i<=kg/5; i++) {
			for(int j=0; j<=kg/3; j++) {
				if((5 * i) + (3 * j) == kg && (num == -1 || i + j < num)) {
					num = i + j;
				}
			}
		}
		System.out.println(num);
	}
}
