package swea_1952_수영장;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int[] prices;
	static int[] monInfo;
	static int result;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = null;
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<=T; tc++) {
			sb = new StringBuilder();
			sb.append('#').append(tc).append(' ');
			prices = new int[4];
			// 기간별 비용을 초기화한다.
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<4; i++) {
				prices[i] = Integer.parseInt(st.nextToken());
			}
			
			monInfo = new int[13];
			// 월별 수영횟수를 초기화 한다.
			st = new StringTokenizer(br.readLine());
			for(int i=1; i<=12; i++) {
				int num = Integer.parseInt(st.nextToken());
				monInfo[i] = num;
			}
			result = Integer.MAX_VALUE;
			dfs(1, 0);
			sb.append(result);
			System.out.println(sb);
		}
	}
	
	static void dfs(int month, int price) {
		// 12월이 넘어가면 가격 비교를 한다.
		if(month > 12) {
			if(result > price) {
				result = price;
			}
			return;
		}
		// 지금 확인하려고 하는 달에 수영을 가면
		if(monInfo[month] > 0) {
			// 일권, 한달, 세달, 1년 각각을 구매했을 때 월, 비용 값을 넣어서 다시 dfs를 돌려준다.
			dfs(month+1, price+(monInfo[month] * prices[0]));
			dfs(month+1, price+prices[1]);
			dfs(month+3, price+prices[2]);
			dfs(13, price+prices[3]);
		} else {
			// 이번달 수영 쉬면 다음달로 넘겨준다.
			dfs(month+1, price);
		}
	}
}
