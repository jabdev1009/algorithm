package swea_러시아;

import java.util.Scanner;

/*
 * 흰색		W : 1줄 이상
 * 파란색	B : 1줄 이상
 * 빨간색	R : 1줄 이상
 * 
 * 행의 수 N
 * 열의 수 M
 * 
 * 제일 위, 아래의 색은 고정
 * 
 * 파란색의 위치 -> 중간에서 파란색의 수가 가장 많은?
 * 흰-파, 파-빨
 */
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			
			// 칸 수
			int count = 0;
			
			char[][] flag = new char[n][];
			for(int i=0; i<n; i++) {
				flag[i] = sc.next().toCharArray();
				// 첫째, 마지막 줄은 색 고정
				if(i == 0) {
					for(int j=0; j<m; j++) {
						if(flag[i][j] != 'W') {
							count++;
						}
					}
				} else if(i == n-1) {
					for(int j=0; j<m; j++) {
						if(flag[i][j] != 'R') {
							count++;
						}
					}
				}
			}
			// WBR순으로 색 갯수
			int[][] colorCount = new int[n-2][3];
			for(int i=1; i<n-1; i++) {
				for(int j=0; j<m; j++) {
					if(flag[i][j] == 'W') {
						colorCount[i-1][0]++;
					} else if(flag[i][j] == 'B') {
						colorCount[i-1][1]++;
					} else {
						colorCount[i-1][2]++;
					}
				}
			}
			
			
			int tmpCount = 0;
			for(int i=0; i<colorCount.length; i++) {
				// i행이 B일 때 
				// 0~i-1행에 대해서 W,B 조합중 각 색의 합이 최대가 되는 경우 top에 저장
				// i+1~color.len의 범위에 대해서 B,R 조합 중 각 색의 합이 최대가 되는 경우 bottom에 저장
				int mid = colorCount[i][1];
				int top = 0;
				int bottom = 0;
				
				// 색이 확정되지 않은 구간 중 파란색을 i행이라고 가정했을 때
				// 미확정 구간 시작~i행 까지 흰, 파란색의 조합 중 각 색의 합이 최대가 되는 경우를 구함
				for(int j=0; j<=i; j++) {
					int w =0; // 흰색 수
					int b =0; // 파란색 수
					int tmptmp=0; // 흰+파란색의 최대값
					for(int k=0; k<j; k++) {
						w+=colorCount[k][0];
					}
					for(int k=j; k<i; k++) {
						b+=colorCount[k][1];
					}
					// 흰+파 조합 최대를 최신화
					if(w+b > tmptmp) {
						tmptmp = w+b;
					}
					// 이제와서 보면 tmptmp없이 바로 top이랑 비교해도 될거같음..
					if(tmptmp>top) {
						top = tmptmp;
					}
					// 0으로 초기화
					w =0;
					b =0;
				}
								
				for(int j=i+1; j<colorCount.length; j++) {
					// B, R 중 합이 최대
					int b =0;
					int r =0;
					int tmptmp =0;
					for(int k=i+1; k<j; k++) {
						b+=colorCount[k][1];
					}
					for(int k=j; k<colorCount.length; k++) {
						r+=colorCount[k][2];
					}
					if(b+r>tmptmp) {
						tmptmp = b+r;
					}
					// 이제와서 보면 tmptmp없이 바로 bottom이랑 비교해도 될거같음..
					if(tmptmp > bottom) {
						bottom = tmptmp;
					}
					b=0;
					r=0;
				}
				
				// 전체 조합 중 최대값 유지
				if(mid+top+bottom > tmpCount) {
					tmpCount = mid+top+bottom; 
				}
			}
			// 첫, 마지막 행을 제외한 전체 칸의 수에서 최대칸을 빼서 변경해야 할 값 
			tmpCount = (colorCount.length * m) - tmpCount;
			// 위에서 구한 값에 첫, 마지막행에서 변경해야 될 색의 수를 합한 결과 출력
			System.out.println("#" + tc+" " +(count+tmpCount));
		}
	}
}
