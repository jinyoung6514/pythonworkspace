package programmers;

import java.util.HashMap;
import java.util.Map;

public class 완주하지_못한_선수 {
  public static void main(String[] args) {
    // //Test1 : "leo"
    // String[] participant = {"leo", "kiki", "eden"};
    // String[] completion = {"eden", "kiki"};
    //Test1 : "leo"
    String[] participant = {"leo", "kiki", "eden","kiki","kiki","kiki","kiki"};
    String[] completion = {"eden", "kiki","kiki","kiki","kiki","kiki"};
    
    System.out.println(solution(participant, completion));
  }

  public static String solution(String[] participant, String[] completion) {
    Map<String,Integer> maps = new HashMap<>();
    for(String completions : completion){
      maps.put(completions,maps.getOrDefault(completions, 0)+1);
    }

    for(String participants : participant){
      if(!maps.containsKey(participants)){
        return participants;
      }else{
        int n = maps.get(participants)-1;
        if(n<0) return participants;
        else maps.put(participants, n);
      }
    }

    return null;
  }
}
