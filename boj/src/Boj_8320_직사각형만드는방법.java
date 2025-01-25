import java.util.Scanner;

public class Boj_8320_직사각형만드는방법 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = 0;
		int n = sc.nextInt();
		
		// 세로
		for(int i=1; i<=n; i++) {
			if(n >= (i*i)) {
				count += (n / i)-(i-1) ;
			}
		}
		System.out.println(count);
	}
}
