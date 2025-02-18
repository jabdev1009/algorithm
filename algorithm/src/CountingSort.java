import java.util.Arrays;

public class CountingSort {
	public static void main(String[] args) {
		int[] arr = { 3, 13, 26, 88, 22, 11, 54, 12 };
		
		int k = -1;
		for(int i=0; i< arr.length; i++) {
			if(arr[i] > k) {
				k = arr[i];
			}
		}
		
		int[] count = new int[k+1];
		for(int i=0; i<arr.length; i++) {
			count[arr[i]]++;
		}
		
		for(int i=1; i<count.length; i++) {
			count[i] += count[i-1];
		}
		
		int[] sortArr = new int[arr.length];
		for(int i=arr.length-1; i>=0; i--) {
			sortArr[--count[arr[i]]] = arr[i];
		}
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(sortArr));
	}
}
