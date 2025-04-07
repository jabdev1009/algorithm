package boj_2887_행성터널;

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] p, rank;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        p = new int[N];
        rank = new int[N];
        int[][] loc = new int[N][4];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++) {
                loc[i][j] = Integer.parseInt(st.nextToken());
            }
            loc[i][3] = i; // 행성 번호 저장
            p[i] = i;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));

        // 좌표별 정렬 후 인접한 노드들만 간선 추가
        for(int i = 0; i < 3; i++) { 
            int idx = i;
            Arrays.sort(loc, Comparator.comparingInt(a -> a[idx]));
            for(int j = 0; j < N - 1; j++) {
                pq.add(new int[]{loc[j][3], loc[j+1][3], Math.abs(loc[j+1][idx] - loc[j][idx])});
            }
        }

        int count = 0, ans = 0;
        while(count < N-1) {
            int[] edge = pq.poll();
            int s = edge[0], e = edge[1], cost = edge[2];
            if(find(s) != find(e)) {
                union(s, e);
                ans += cost;
                count++;
            }
        }
        System.out.println(ans);
    }
    
    static int find(int x) {
        if(x != p[x]) {
            p[x] = find(p[x]);
        }
        return p[x];
    }
    
    static void union(int x, int y) {
        int px = find(x), py = find(y);
        if(px != py) {
            if(rank[px] > rank[py]) p[py] = px;
            else if(rank[px] < rank[py]) p[px] = py;
            else { p[py] = px; rank[px]++; }
        }
    }
}
