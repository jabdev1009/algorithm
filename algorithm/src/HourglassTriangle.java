import java.util.Scanner;

public class HourglassTriangle {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i=1; i<=n; i++) {
			int middle = (n+1) / 2;
			int maxSpace = (n-1) / 2;
			int space = maxSpace - Math.abs(middle-i);
			// 앞 공백
			for(int j=0; j<space; j++) {
				System.out.print(" ");
			}
			// 별
			for(int j=0; j < n-(2*space); j++) {
				System.out.print("*");
				
			}
			// 뒤 공백
			for(int j=0; j<space; j++) {
				System.out.print(" ");
			}
			System.out.println();
		}
	}
}