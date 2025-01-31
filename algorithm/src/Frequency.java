import java.util.Arrays;
import java.util.Scanner;

public class Frequency {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		String[] nums = str.split(" ");
		int[] numerics = new int[nums.length];
		for(int i=0; i<nums.length; i++) {
			numerics[i] = Integer.parseInt(nums[i]);
		}
		Arrays.sort(numerics);
		int nullIdx = 0;
		int[][] result = new int[numerics.length][2];
		
		for(int i=0; i<numerics.length; i++) {
			int num = numerics[i];
			for(int j=0; j<=nullIdx; j++) {
				if(j == nullIdx && num != result[j][0]) {
					result[nullIdx][0] = num;
					result[nullIdx][1]++;
					nullIdx++;
					break;
				} else if(num == result[j][0]){
					result[j][1]++;
					break;
				}
			}
		}
		for(int i=0; i<nullIdx; i++) {
			System.out.print(result[i][0]+" ");
			System.out.println(result[i][1]);
		}
	}
}
