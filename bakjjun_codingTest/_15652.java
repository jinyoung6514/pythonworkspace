package bakjjun_codingTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _15652{
    static int answer[];
    static int N,M;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer stk = new StringTokenizer(br.readLine()," ");
   
       N = Integer.parseInt(stk.nextToken());
       M = Integer.parseInt(stk.nextToken());

       answer = new int[M];
        
       Dfs(1,0);

       System.out.print(sb);
    }

    public static void Dfs(int start,int depth){
        if(depth == M){
            for(int val : answer){
                sb.append(val).append(' ');
            }
            sb.append("\n");
            return;
       }
       
       for(int i = start; i <= N; i++){
            answer[depth] = i;
            Dfs(i, depth+1);
        }
    }
}