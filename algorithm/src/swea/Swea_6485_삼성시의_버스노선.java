package swea;

import java.util.Scanner;

public class Swea_6485_삼성시의_버스노선 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case=1; test_case<=T; test_case++) {
			int n = sc.nextInt();
			int[][] routes = new int[n][2];
			for(int i=0; i<n; i++) {
				routes[i][0] = sc.nextInt();
				routes[i][1] = sc.nextInt();
			}
			int p = sc.nextInt();
			int[][] stops = new int[p][2];
			for(int i=0; i<p; i++) {
				stops[i][0] = sc.nextInt();
			}
			
			for(int i=0; i<routes.length; i++ ) {
				int start = routes[i][0];
				int end = routes[i][1];
				for(int j=0; j<stops.length; j++) {
					int stop = stops[j][0]; 
					if(stop >= start && stop <= end) {
						stops[j][1]++;
					}
				}
			}
			System.out.print("#"+test_case+" ");
			for(int i=0; i<stops.length; i++) {
				System.out.print(stops[i][1] +" ");
			}
			System.out.println();
		}
	}
}
