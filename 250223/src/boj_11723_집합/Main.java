package boj_11723_집합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static boolean[] arr = new boolean[21];
	public static void main(String[] args) throws IOException {
		
		int n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			int num = 0;
			if(!command.equals("all") && !command.equals("empty")) {
				num = Integer.parseInt(st.nextToken());
			}
			if(command.equals("add")) {
				arr[num] = true;
			} else if(command.equals("remove")) {
				arr[num] = false;
			} else if(command.equals("check")) {
				sb.append(arr[num]?1:0).append("\n");
			} else if(command.equals("toggle")) {
				arr[num] = !arr[num];
			} else if(command.equals("all")) {
				Arrays.fill(arr, true);
			} else if(command.equals("empty")) {
				Arrays.fill(arr,false);
			}
		}
		System.out.println(sb);
	}
}
