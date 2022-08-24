package bakjjun_codingTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class _2108{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for(int i = 0; i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        double ave = 0;
        //합
        for(int i=0; i<N;i++){
            ave += arr[i];
        }
        //평균
        ave = Math.round(ave/N);
        sb.append((int)ave + "\n");
        //중앙값
        sb.append(arr[(int)(N/2)]+ "\n");
        //최빈값
        int[] plusindex = new int[4001];
        int[] minusindex = new int[4001];
        ArrayList<Integer> list = new ArrayList<>();
        int max = 0;
        for(int i = 0;i<N;i++){
            if(arr[i]>=0){
                plusindex[arr[i]]++;
            }else{
                minusindex[-arr[i]]++;
            }
        }
        for(int i = 0; i < plusindex.length; i++){
            if(plusindex[i]==0 && minusindex[i]==0){
                continue;
            }
            if(plusindex[i] >= max){
                if(plusindex[i] > max){
                    list.clear();
                }
                max = plusindex[i];
                list.add(i);
            }

            if(minusindex[i] >= max){
                if(minusindex[i] > max){
                    list.clear();
                }
                max = minusindex[i];
                list.add(-i);
            }
        }
        if(list.size() == 1){
            sb.append(list.get(0)+ "\n");
        }else if(list.size() == N){
            sb.append(arr[1] +"\n");
        }else{
            Collections.sort(list);
            sb.append(list.get(1)+"\n");
        }
        
        //범위
        if(N==1){
            sb.append(0);
        }else{
            sb.append(arr[N-1] - arr[0]);
        }

        System.out.println(sb);
    }
}