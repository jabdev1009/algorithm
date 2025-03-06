package boj_15686_치킨배달;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader br;
	static StringTokenizer st;
	
	static Map<Integer, int[]> chick;
	static Map<Integer, int[]> house;
	static int[][] map;
	static int n;
	static int m;
	
	static int min;
	static int[] sel;
	static int chickCount;
	static int houseCount;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][n];
		chick = new HashMap<>();
		house = new HashMap<>();
		sel = new int[m];
		min = Integer.MAX_VALUE;
		chickCount = 0;
		houseCount = 0;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				int num =  Integer.parseInt(st.nextToken());
				map[i][j] = num;
				
				if(num == 2) {
					chick.put(chickCount++, new int[] {j, i});
				} else if(num == 1) {
					house.put(houseCount++, new int[] {j, i});
				}
			}
		}
		
		comb(0,0);
		System.out.println(min);
	}
	
	static void comb(int idx, int sidx) {
		if(sidx == m) {
			// m개의 닭집을 골라서 집들과의 거리가 최소가 되는 값을 찾는다.
			int[][] cal = new int[m][houseCount];
			for(int i=0; i<m; i++) {
				int chickX = chick.get(sel[i])[0];
				int chickY = chick.get(sel[i])[1];
				
				Set<Integer> keys = house.keySet();
				Iterator<Integer> itr = keys.iterator();
				int calIdx = 0;
				while(itr.hasNext()) {
					Integer key = itr.next();
					int[] arr = house.get(key);
					int houseX = arr[0];
					int houseY = arr[1];
					
					cal[i][calIdx++] = Math.abs(houseX - chickX) + Math.abs(houseY-chickY);
				}
			}
			int sum = 0;
			for(int i=0; i<houseCount; i++) {
				int calMin = Integer.MAX_VALUE;
				for(int j=0; j<chickCount; j++) {
					int tmp = cal[j][i];
					if(calMin> tmp) {
						calMin = tmp;
					}
				}
				sum+=calMin;
				
			}
			
			min = Math.min(min, sum);
			return;
		}
		
		for(int i=idx; i<=chickCount-m+sidx; i++) {
			sel[sidx] = i;
			comb(i+1, sidx+1);
		}
	}
}
