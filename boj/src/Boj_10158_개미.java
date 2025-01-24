import java.util.Scanner;

public class Boj_10158_개미 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int l = sc.nextInt();
		int w = sc.nextInt();
		
		int x = sc.nextInt();
		int y = sc.nextInt();
		int time = sc.nextInt();
		sc.close();
		/*
		 * 메모리 초과
		boolean dx = true;
		boolean dy = true;
		
		while(time-- > 0) {
			if(x == l || x == 0) {
				dx = !dx;
			}
			if(y == w || y == 0) {
				dy = !dy;
			}
			x = dx ? ++x : --x;
			y = dy ? ++y : --y;
		}
		*/
		// 시간초과..
		x = ((x+time) / l) % 2 == 0 ? ((x+time) % l) : l - ((x+time) % l) ;
		y = ((y+time) / w) % 2 == 0 ? ((y+time) % w) : w - ((y+time) % w) ;
		
		System.out.println(x + " " + y);
	}
}
