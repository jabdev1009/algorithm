package boj_10871_X보다작은수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		while(st.hasMoreTokens()) {
			int num = Integer.parseInt(st.nextToken());
			if(num < X) {
				sb.append(num).append(' ');
			}
		}
		System.out.println(sb);
	}
}
