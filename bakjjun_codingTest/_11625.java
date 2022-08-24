package bakjjun_codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class _11625 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    Map<Long,Integer> card = new HashMap<>();
    for(int i=0; i<N; i++){
      long input = Long.parseLong(br.readLine());
      if(card.containsKey(input)){
        card.replace(input, card.get(input)+1);
      }else{
        card.put(input, 1);
      }
    }

    Long keyValue = 0L;
    int temp = 0;
    for(Long key: card.keySet()){
      if(temp<card.get(key)){
        temp = card.get(key);
        keyValue = key;
      }else if(temp == card.get(key) && keyValue > key){
        keyValue = key;
      }
    }

    System.out.println(keyValue);
  }
}
