package swea_2930_힙;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			int n = sc.nextInt();
			int[] heap = new int[n+1];
			int heapSize = 0;
			System.out.print("#"+tc+" ");
			for(int i=1; i<=n; i++) {
				int todo = sc.nextInt();
				if(todo == 1) {
					int num = sc.nextInt();
					heap[++heapSize] = num;
					
					// 부모가 항상 커야하기 때문에
					int ch = heapSize;
					int p = ch / 2; 
					while(p > 0 && heap[p] < heap[ch]) {
						int tmp = heap[p];
						heap[p] = heap[ch];
						heap[ch] = tmp;
						
						ch = p;
						p = ch/2;
					}
				} else {
					if(heapSize == 0) {
						System.out.print(-1+" ");
						continue;
					}
					int root = heap[1];
					heap[1] = heap[heapSize--];
					
					int p = 1;
					int ch = p*2;
					if(ch+1<=heapSize && heap[ch] < heap[ch+1]) {
						ch++;
					}
					
					while(ch <= heapSize && heap[p] < heap[ch]) {
						int tmp = heap[p];
						heap[p] = heap[ch];
						heap[ch] = tmp;
						
						p = ch;
						ch = p * 2; //왼자세팅
						if(ch+1 <= heapSize && heap[ch] < heap[ch+1]) {
							ch+=1; //오자로 교환
						}
					}
					System.out.print(root+" ");
				}
			}
			System.out.println();
		}
	}
}
