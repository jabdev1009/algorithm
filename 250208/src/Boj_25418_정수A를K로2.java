import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Boj_25418_정수A를K로2 {
	static int min = 0;
	static int a;
	static int k;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		a = sc.nextInt();
		k = sc.nextInt();
		
		int[] info = {a,0};
		
		bfs(info);
		
		System.out.println(min);
	}
	// visited 처리를 어떻게 해주지
	public static void bfs(int[] info) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(info);
		Set<Integer> visited = new HashSet<>();
		while(!q.isEmpty()) {
			int[] arr = q.poll();
			int now = arr[0];
			int count = arr[1];
			
			if(now == k) {
				min = count;
				break;
			} else if(now <= k && !visited.contains(now)) {
				visited.add(now);
				if(now+1 <= k) {
					q.offer(new int[] {now+1, count+1});
				}
				if(now*2 <= k) {
					q.offer(new int[] {now*2, count+1});
				}
			}
		}
	}
}
