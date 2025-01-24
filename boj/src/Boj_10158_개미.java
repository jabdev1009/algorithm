import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Boj_10158_개미 {
	public static void main(String[] args) throws IOException {
		// 시간초과..
//		Scanner sc = new Scanner(System.in);
//		int l = sc.nextInt();
//		int w = sc.nextInt();
//		
//		int x = sc.nextInt();
//		int y = sc.nextInt();
//		int time = sc.nextInt();
//		sc.close();
		/*
		 * 메모리 초과
		boolean dx = true;
		boolean dy = true;
		
		주어진 시간만큼 반복하면서 벽을 만나면 증가<->감소
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
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int l = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int time = Integer.parseInt(br.readLine());
		
		// 
		/*
		 * 원점에서 가로로 움직인 전체 거리 = x+time
		 * 움직일 수 있는 범위의 가로길이로 나눈 몫, 나머지 -> 왕복 횟수, 왕복이후 추가이동거리 
		 * 왕복 횟수 % 2 => 0 = 원점, 1 = 가로최대 => 1이면 가로최대 - 나머지
		 * 세로에도 동일한 규칙
		 */
		x = ((x+time) / l) % 2 == 0 ? ((x+time) % l) : l - ((x+time) % l) ;
		y = ((y+time) / w) % 2 == 0 ? ((y+time) % w) : w - ((y+time) % w) ;
		
//		x = ((x + time) % (2 * l)) % l;
//		y = ((y + time) % (2 * w)) % w;
		
		System.out.println(x + " " + y);
	}
}
