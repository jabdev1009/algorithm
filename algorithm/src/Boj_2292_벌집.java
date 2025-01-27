import java.util.Scanner;

public class Boj_2292_벌집 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int level = 1;
		int max = 1;
		
		// 1번에서 level번 만에 갈 수 있는 칸의 최대값 max -> max값은 6의 배수의 합만큼 증가
		// max>=level인 범위의 level값 출력
		while(true) {
			if(max >= n) {
				break;
			} else {
				max += 6*level++;
			}
		}
		System.out.println(level);
	}
}
