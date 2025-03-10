package boj_15787_기차가어둠을헤치고;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int command = 0;
		int tNum = 0;
		int seat = 0;
			
		int[] train = new int[n+1];
		Set<Integer> list = new HashSet<>();
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			command = Integer.parseInt(st.nextToken());
			tNum = Integer.parseInt(st.nextToken());
			if(command == 1 || command == 2) {
				seat = Integer.parseInt(st.nextToken());
			}
			
			switch (command) {
				case 1: {
					train[tNum] |= (1<<seat-1);
                    break;
				}
				case 2: {
					train[tNum] &= ~(1<<seat-1);
                    break;
				}
				case 3: {
					// 20자리 제한
                    train[tNum] <<= 1;
                    train[tNum] &= ~(1 << 20);
                    break;
				}
				case 4: {
                    train[tNum] >>= 1;
                    break;
				}
			}
			System.out.println(Arrays.toString(train));
		}
		
		for(int i=1; i<=n; i++) {
				list.add(train[i]);
		}
		System.out.println(list.size());
		br.close();
	}
}
///

///


