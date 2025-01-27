import java.util.Arrays;
import java.util.Scanner;

public class Boj_11399_ATM {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int p = sc.nextInt();
		int[] time = new int[p];
		for(int i=0; i<p; i++) {
			time[i] = sc.nextInt();
		}
		Arrays.sort(time);
		int sum = 0;
		int result = 0;
		for(int i=0; i<p; i++) {
			sum += time[i];
			result +=sum;
		}
		System.out.println(result);
	}
}
