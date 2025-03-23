package boj_13164_행복유치원;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		if(n <= k) {
			System.out.println(0);
			return;
		}
		String[] censors = br.readLine().split(" ");
		
		int[] arr = new int[censors.length];
		for(int i=0; i<arr.length; i++) {
			arr[i] = Integer.parseInt(censors[i]);
		}
		
		Arrays.sort(arr);
		
		int[] diff = new int[arr.length-1];
		for(int i=0; i<diff.length; i++) {
			diff[i] = arr[i+1] - arr[i];
		}
		
		Arrays.sort(diff);
		
		int result = 0;
		
		for(int i=0; i<n-k; i++) {
			result += diff[i];
		}
		System.out.println(result);
	}
}
