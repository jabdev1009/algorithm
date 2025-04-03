package swea_1970_쉬운거스름돈;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	static int[] money = {1,5,10,50,100,500,1000,5000};
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++, sb.append('\n')) {
			sb.append('#').append(tc).append('\n');
			N = Integer.parseInt(br.readLine());
			int tmp = N/10;
			for(int i=money.length-1; i>=0; i--) {
				sb.append(tmp / money[i]).append(' ');
				tmp %= money[i];
			}
		}
		System.out.println(sb);
	}
}