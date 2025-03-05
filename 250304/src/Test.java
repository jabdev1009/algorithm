import java.util.*;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        
        int tc = 1; 
        while(tc<=T) {
            StringBuilder sb = new StringBuilder();
            int N = Integer.parseInt(sc.nextLine());
            int[] tree = new int[N]; 
            
            int max = 0; 
            String[] input = sc.nextLine().split(" ");
            for(int i=0; i<N; i++) {
                tree[i] = Integer.parseInt(input[i]);
                max = Math.max(max, tree[i]);
            }
            
            Stack<Integer> st1 = new Stack<>(); //gap을 2로 나눈 나머지인 1만 들어감
            Stack<Integer> st2 = new Stack<>(); //gap을 2로 나눈 몫의 개수만큼 2가 들어감. 
            
            for(int i=0; i<N; i++) {
                int gap = max-tree[i];

                if(gap%2==1) st1.push(1);
                int gap2 = gap / 2; 
                for(int j=0; j<gap2; j++) st2.push(2);
            }
            
            int dayCnt2 = 0; //2일 단위 데이카운트 
            while(!st1.isEmpty() && !st2.isEmpty()) {
                st1.pop();
                st2.pop();
                dayCnt2++;
            }
            
            int dayCnt4 = 0; //4일 단위 데이카운트
            if(!st2.isEmpty()) { //2가 남았으면 3개씩 짝지음 
                while(st2.size()>2) {
                    st2.pop();
                    st2.pop();
                    st2.pop();
                    dayCnt4++;
                }
            }
            
            int dayCnt1 = 0; //1일 단위 데이카운트
            if(!st2.isEmpty()) {
                if(st2.size()==1) {
                    dayCnt1 += 2;
                } else if(st2.size()==2) {
                    dayCnt1 += 3;
                }                
            } else if(!st1.isEmpty()) {  
                dayCnt1 += (2*st1.size())-1; //끝까지 남은 하루단위들
            }
            
            int result = dayCnt1+dayCnt2*2+dayCnt4*4;
            sb.append("#"+tc+" "+result);
            System.out.println(sb);
                    
            tc++;
        }
                
    }
}
