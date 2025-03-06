package swea_14229_백만개의정수정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		arr = new int[1000000];
		for(int i=0; i<arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		quickSort(0, arr.length-1);
		
		System.out.println(arr[500000]);
		
	}
	static void quickSort(int start, int end) {
		if(start < end) {
			int pivot = participate(start, end);
			quickSort(start, pivot-1);
			quickSort(pivot+1, end);
		}
	}
	
	static int participate(int start, int end) {
		int pivot = arr[start];
		
		int L = start+1;
		int R = end;
		
		while(L <= R) {
			while(arr[L]<=pivot && L<=R) {
				L++;
			}
			while(arr[R] > pivot) {
				R--;
			}
			
			if(L < R) {
				int tmp = arr[L];
				arr[L] = arr[R];
				arr[R] = tmp;
			}
		}
		
		int tmp = arr[start];
		arr[start] = arr[R];
		arr[R] = tmp;
		
		return R;
	}
}
