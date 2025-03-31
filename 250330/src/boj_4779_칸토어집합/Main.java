package boj_4779_칸토어집합;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static char[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			String str = br.readLine();
			if(str == null || str.isBlank()) {
				break;
			}
			int num = Integer.parseInt(str);
			int len = (int)Math.pow(3, num);
			arr = new char[len];
			Arrays.fill(arr, '-');
			
			dfs(len, 0);
			for(int i=0; i<len; i++) {
				sb.append(arr[i]);
			}
			
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
	
	static void dfs(int length, int start) {
		if(length == 1) {
			return;
		}
		for(int i=0; i<3; i++) {
			int nextLen = length/3;
			if(i == 1) {
				for(int j=start+nextLen; j<start+(nextLen*2); j++) {
					arr[j] = ' ';
				}
			} else {
				dfs(nextLen, start + nextLen*(i));
			}
		}
	}
}
