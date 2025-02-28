package boj_28089_응애_HARD;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    
    static long[] baby;
    static long[] left;
    static long[] right;
    static int size;
    static int rem;
    
    public static void main(String args[]) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long k = Long.parseLong(st.nextToken());
        
        // 각 비트마스킹의 크기는 50비트로 설정
        size = (n-1)/50+1;
        rem = n%50;
        baby = new long[size];
        left = new long[size];
        right = new long[size];
        
        // 초기세팅
        for (int i=0;i<m;i++) {
            int idx = Integer.parseInt(br.readLine());
            int val = idx/50;
            int mod = idx%50;
            baby[val]|=(1L<<mod);
        }
        for (long i=0;i<k;i++) {
            for (int j=0;j<size;j++) {
                left[j]=(baby[j]&~(1L<<s(j)))<<1|((baby[b(j+1)]&1L<<s(j+1))!=0?1:0);
                right[j]=(baby[j]>>1)|((baby[b(j-1)]&1)!=0?1L<<s(j):0);
            }
            for (int j=0;j<size;j++) {
                baby[j]=left[j]^right[j];
            }
        }
        int sum = 0;
        for (int i=0;i<size;i++) {
            sum+=Long.bitCount(baby[i]);
        }
        sb.append(sum);
        System.out.println(sb);
    }
    
    static int b(int x) {
        return (x+size)%size;
    }
    
    static int s(int x) {
        return (x+size)%size==size-1?rem-1:49;
    }
}
