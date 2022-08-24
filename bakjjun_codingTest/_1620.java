package bakjjun_codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class _1620{
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int M = Integer.parseInt(st.nextToken());
    int N = Integer.parseInt(st.nextToken());

    Map<String,Integer> dogam = new HashMap<String,Integer>();
    StringBuilder sb = new StringBuilder();
    String[] namearr = new String[M+1];
    
    for(int i=1; i<M+1; i++){
      String name = br.readLine();
      dogam.put(name,i);
      namearr[i] = name;
    }

    for(int i=0; i<N; i++){
      String input = br.readLine();
      if(dogam.containsKey(input)){
        sb.append(dogam.get(input) + "\n");
      }else{
        sb.append(namearr[Integer.parseInt(input)] + "\n");
      }
    }
    System.out.println(sb);
  }
}