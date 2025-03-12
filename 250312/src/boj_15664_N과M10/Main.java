package boj_15664_N과M10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	static int N;
	static int M;
	static int[] sel;
	static int[] nums;
	static StringBuilder sb;
	
	static TreeSet<int[]> set;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		sel = new int[M];
		nums = new int[N];
		String[] arr = br.readLine().split(" ");
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(arr[i]);
		}
		set = new TreeSet<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				int len = o1.length;
				for(int i=0; i<len; i++) {
					if(o1[i] != o2[i]) {
						return o1[i]-o2[i];
					}
				}
				return 0;
			}
		});
		
		Arrays.sort(nums);
		
		sequence(0, 0, 0);
		
		Iterator itr = set.iterator();
		while(itr.hasNext()) {
			int[] seq = (int[])itr.next();
			for(int i=0; i<seq.length; i++) {
				sb.append(seq[i]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	static void sequence(int idx, int sidx, int visited) {
		if(sidx == M) {
			set.add(Arrays.copyOf(sel, M));
			return;
		}
		for(int i=idx; i<N; i++) {
			if((visited & (1<<i)) > 0) {
				continue;
			}
			sel[sidx] = nums[i];
			sequence(i, sidx+1, visited|1<<i);
		}
	}
}
