package swea;

import java.util.Scanner;

public class Swea_1204_최빈수_구하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i=0; i<T; i++) {
			int test_case = sc.nextInt();
			int[][] scores = new int[1000][2];
			int idx = 0;
			for(int j=0; j<1000; j++) {
				int score = sc.nextInt();
				for(int k=0; k<=idx; k++) {
					if(idx == 0) {
						scores[k][0] = score;
						scores[k][1]++;
						idx++;
					} else if(score != scores[idx-1][0]) {
						scores[idx][0] = score;
						scores[idx][1]++;
						idx++;
					} else if(score == scores[k][0]) {
						scores[k][1]++;
					}
				}
			}
			int max = 0;
			int count = 0;
			for(int j=0; j<idx; j++) {
				if(scores[j][1] > count) {
					count = scores[j][1];
					max = scores[j][0];
				} else if(scores[j][1] == count && scores[j][0] > max) {
					max = scores[j][0];
				}
			}
			System.out.println("#"+test_case+" "+max);
		}
	}
}
