package bakjjun_codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class _9375 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //테스트 케이스 수 받기
    int t = Integer.parseInt(br.readLine());
    StringTokenizer st;
    Map<String,Integer> map;
    StringBuilder sb = new StringBuilder();

    for(int i=0; i<t; i++){
      map = new HashMap<>();
      int count = 1;
      //의상개수
      int n = Integer.parseInt(br.readLine());
      //종류 map에 넣기
      for(int j=0; j<n; j++){
        st = new StringTokenizer(br.readLine()); st.nextToken();
        String name = st.nextToken();
        if(map.containsKey(name)){
          int num = map.get(name);
          map.put(name, num+1);
        }else{
          map.put(name, 1);
        }
      }
      //조합 계산
      for(String key : map.keySet()){
        int value = map.get(key);
        count *= value+1;
      }
      sb.append(count-1+"\n");
    }
    System.out.println(sb);
  }
}
