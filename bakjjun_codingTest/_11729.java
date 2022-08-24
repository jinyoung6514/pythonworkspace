package bakjjun_codingTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _11729 {
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        sb.append((int)Math.pow(2, N) - 1 + "\n");
        start(N, 1, 2, 3);
        System.out.println(sb);
    }

    public static void start(int n, int start, int mid, int end){
        if (n == 1){
            sb.append(start+ " " + end + "\n");
            return;
        }

        //빈칸에 n-1원판만큼 넘기기
        start(n-1,start,end,mid);

        //3번째 제일 큰 원판 넘기기
        sb.append(start + " " + end + "\n");

        //다시 남는 칸에 n-1만큼 원판 넘기기
        start(n-1,mid,start,end);
    }
}
