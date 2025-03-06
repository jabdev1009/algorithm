import java.util.Arrays;
import java.util.Scanner;

public class Test {
public static void main(String[] args) {
	Scanner sc = new Scanner (System.in);
	
	int T = sc.nextInt();
	
	for (int tc = 1; tc <= T; tc++) {
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		int [] arr = new int [N];
		
		for (int n = 0; n < N; n++) {
			arr[n] = sc.nextInt();
		}
		
		int sum = 1;
		int max = 0;
		
		Arrays.sort(arr);
		
		for (int n = N-1; n > 1; n--) {
			for (int i = 0; i < n; i++) {
				if (arr[n]-arr[i] <= K) {
					sum++;
				}
			}
			max = Math.max(sum, max);
			sum = 1;
		}
		
		System.out.println("#" + tc + " " + max);
		
	}//tc
}//main
}