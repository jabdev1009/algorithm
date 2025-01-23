import java.util.Scanner;

// 큰 사각형 넓이 - 작은 사각형 넓이
public class Boj_2477_참외밭 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 1m^2 당 수확물
		int per = sc.nextInt();
		int arrLen = 6;
		int[] side = new int[arrLen]; // 방위
		int[] len = new int[arrLen]; // 길이
		
		for(int i=0; i<arrLen; i++) {
			side[i]=sc.nextInt();
			len[i]=sc.nextInt();
		}
		
		/*
		 	side에 1번만 등장하는 수의 idx를 구하고
		 	len에서 해당 idx에 해당하는 값의 곱 = 큰 사각형
		 	idx의 차의 절대값이 1인 경우 idx갑 중 큰 것 idx+2 idx+3
		 */
		int idxW = 0;
		int idxL = 0;
		int maxW = 0;
		int maxL = 0;
		for(int i=0; i<6; i++) {
			if(side[i]<=2) {
				if(maxW < len[i]) {
					maxW = len[i];
					idxW = i;
				}
			} else {
				if(maxL < len[i]) {
					maxL = len[i];
					idxL = i;
				}
			}
		}
		int smallR = 0;
		if(Math.abs(idxW-idxL) == 1) {
			int tmp = idxW > idxL ? idxW : idxL;
			smallR = len[(tmp+2)%6] * len[(tmp+3)%6];
		} else {
			int tmp = idxW > idxL ? idxL : idxW;
			smallR = len[(tmp+2)%6] * len[(tmp+3)%6];
		}
		System.out.println(((maxW*maxL)-smallR)*per);
	}
}
