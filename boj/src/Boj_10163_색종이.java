import java.util.Scanner;

public class Boj_10163_색종이 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int[][] arr = new int[num+1][]; // idx 조정을 피하기 위한 num+1
		int[][] map = new int[1001][1001];
		for(int i=1; i<=num; i++) {
			arr[i] = new int[] {sc.nextInt(),sc.nextInt(),sc.nextInt(),sc.nextInt()}; 
		}
		
		// 덮히고 남은 면적을 구하기 -> 색종이 역순으로 면적이 온전함 -> 역순으로 map에 숫자 채워두고 비어있지 않으면 채울 수 없음
		int count = 0;
		for(int i=num; i>0; i--) {
			int x = arr[i][0];
			int y = arr[i][1];
			int w = arr[i][2];
			int l = arr[i][3];
			for(int j=x; j<x+w; j++) {
				for(int k=y; k<y+l; k++) {
					if(map[j][k] == 0) {
						map[j][k] = i;
						count++;
					}
				}
			}
			arr[i][0] = count;
			count = 0;
		}
		for(int i=1; i<=num; i++) {
			System.out.println(arr[i][0]);
		}
	}
}
