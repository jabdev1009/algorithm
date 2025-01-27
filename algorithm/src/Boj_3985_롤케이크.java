import java.util.Scanner;

public class Boj_3985_롤케이크 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// ㅣ번째 조각 idx예외 방지용 +1
		int[] l = new int[sc.nextInt()+1];
		int n = sc.nextInt();
		// 조각 시작, 끝
		int start = 0;
		int end = 0;
		// 기대, 기대idx, 실제, 실제idx
		int expect = 0;
		int expectIdx = 0;
		int real = 0;
		int realIdx = 0;
		
		// 반복문 돌면서 사람별 기대 조각수 구한 뒤 현재 저장된 기대 조각수 비교
		for(int i=1; i<=n; i++) {
			start = sc.nextInt();
			end = sc.nextInt();
			int tmp = end - start + 1;
			if(tmp > expect) {
				expect = tmp;
				expectIdx = i;
			}
			tmp = 0;
			// 조각 배열에 들어있는 값 == 0 -> 아직 찜X, 현재 사람 idx로 찜 표시 + 몇개 찜 했는지 카운팅 해서 기존 real값과 비교 
			// 조각 배열에 들어있는 값 != 0 -> 선점한 사람 있어서 찜 못함
			for(int j=start; j<=end; j++) {
				if(l[j] == 0) {
					l[j] = i;
					tmp++;
				}
			}
			if(tmp > real) {
				real = tmp;
				realIdx = i;
			}
		}
		System.out.println(expectIdx);
		System.out.println(realIdx);
	}
}
