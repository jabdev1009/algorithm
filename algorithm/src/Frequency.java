import java.util.Arrays;
import java.util.Scanner;

public class Frequency {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		String[] strNums = str.split(" ");
		int[] nums = new int[strNums.length];
		for(int i=0; i<strNums.length; i++) {
			nums[i] = Integer.parseInt(strNums[i]);
		}
		// 오름차순 -> result에 작은 수 부터 담기 위해서
		Arrays.sort(nums);
		// result에 비어있는 idx 위치
		int nullIdx = 0;
		// {숫자, 갯수},{숫자, 갯수} ...
		int[][] result = new int[nums.length][2];
		
		// 반복문 돌다가 result에 있으면 갯수++
		// 비어있는 idx까지 가면 그자리에 숫자 넣어주고 갯수++, nullIdx++
		for(int i=0; i<nums.length; i++) {
			int num = nums[i];
			for(int j=0; j<=nullIdx; j++) {
				if(j == nullIdx) {
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
		
		// 출력
		for(int i=0; i<nullIdx; i++) {
			System.out.print(result[i][0]+" ");
			System.out.println(result[i][1]);
		}
	}
}
