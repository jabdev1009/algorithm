package swea;

import java.util.Scanner;

public class Swea_2063_중간값_찾기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[sc.nextInt()];
		for(int i=0; i<arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		
//		Arrays.sort(arr);
		int[] sArr = countingSort(arr);
		
		System.out.println(sArr[sArr.length/2]);
	}
	
	static int[] countingSort(int[] arr) {
		int k = -1;
		for(int i=0; i<arr.length; i++) {
			k = arr[i] > k ? arr[i] : k;
		}
		System.out.println(k);
		int[] count = new int[k+1];
		for(int i=0; i<arr.length; i++) {
			count[arr[i]]++;
		}
		
		for(int i=1; i<count.length; i++) {
			count[i] = count[i] + count[i-1];
		}
		
		int[] sortArr = new int[arr.length];
		for(int i=arr.length-1; i>=0; i--) {
			sortArr[--count[arr[i]]] = arr[i];
		}
		return sortArr;
	}
}
