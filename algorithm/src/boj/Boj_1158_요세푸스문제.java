import java.util.Scanner;

public class Boj_1158_요세푸스문제 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<arr.length; i++) {
			arr[i] = i+1;
		}
		String result = "<";
		int idx = k-1;
		for(int i=0; i<n; i++) {
			while(true) {
				if(arr[idx] != 0) {
					result += arr[idx];
					if(i == n-1) {
						result += ">";
						break;
					} else {
						result += ", ";
					}
					arr[idx] = 0;
					
					int count = 0;
					while(count < k) {
						idx++;
						if(idx > n-1) {
							idx -= n;
						}
						if(arr[idx] != 0) {
							count++;
						}
					}
					break;
				}
			}
		}
		System.out.println(result);
	}
}