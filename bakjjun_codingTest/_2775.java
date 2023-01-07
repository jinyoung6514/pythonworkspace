package bakjjun_codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _2775 {
  
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    int t = Integer.parseInt(br.readLine());

    for(int i=0; i<t; i++){
      int a = Integer.parseInt(br.readLine());
      int b = Integer.parseInt(br.readLine());

      List<Map<Integer, Integer>> list = new ArrayList<>();
      Map<Integer, Integer> map = new HashMap<>();
      for(int j=1; j<b+1; j++){
        map.put(j, j);
      }
      list.add(map);

      for (int j = 0; j < a; j++) {
        int cnt = 1;
        int value = 0;
        map = new HashMap<>();
        for (Map.Entry<Integer, Integer> floor : list.get(j).entrySet()) {
          value += floor.getValue();
          map.put(cnt++, value);
        }
        list.add(map);
      }

      System.out.println(list.get(a).get(b));
    }
  }
}
