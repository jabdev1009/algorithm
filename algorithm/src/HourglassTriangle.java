import java.util.Scanner;

public class HourglassTriangle {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i=1; i<=n; i++) {
			int middle = (n+1) / 2;
			int tmp = (n-1) / 2;
			int num = tmp - Math.abs(middle-i);
			for(int j=0; j<num; j++) {
				// 별 앞 공백
				System.out.print(" ");
			}
			for(int j=1; j <= n-(2*num); j++) {
				// 별
				System.out.print("*");
				
			}
			for(int j=0; j<num; j++) {
				// 별 뒤 공백
				System.out.print(" ");
			}
			System.out.println();
		}
	}
}