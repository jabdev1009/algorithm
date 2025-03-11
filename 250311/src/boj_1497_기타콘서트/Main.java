package boj_1497_기타콘서트;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static ArrayList<Long> list;
	static long[] info;
	static int ans;
	static int songs;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		ans = -1;
		songs = 0;
		info = new long[n];
		list = new ArrayList<Long>();
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			st.nextToken();
			String str = st.nextToken();
			long num = 0;
			for(int j=0; j<m; j++) {
				if(str.charAt(j) == 'Y') {
					num += (1L<<(m-1-j));
				}
			}
			info[i] = num;
		}
		
		comb(0,0);
		
		System.out.println(ans);
		
	}
	// 몇개의 기타로 몇곡을 연주할 수 있는지
	// 사용한 기타 -> visited
	static void comb(int size, int visited) {
		if(size == n) {
			return;
		}
		for(int i=0; i<n; i++) {
			if((visited & (1<<i)) > 0) {
				continue;
			}
			list.add(info[i]);
			chkList();
			comb(size+1, (visited | 1<<i));
			list.remove(list.size()-1);
		}
	}
	
	static boolean chkList() {
		
		// size = 기타 수
		int size = list.size();
		long num = 0;
		
		for(int i=0; i<size; i++) {
			num |= list.get(i);
		}
		int x = Long.bitCount(num);
		// 곡 수가 크면 기타수 초기화
		// 곡 수가 같은면 적은 기타 수 유지
		if(x > songs) {
			ans = size;
			songs = x;
		} else if(x == songs) {
			if(ans > size) {
				ans = size;
			}
		}
		return true;
	}
}
