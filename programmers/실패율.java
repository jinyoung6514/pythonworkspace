package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 실패율 {
  public static void main(String[] args) {
    //Test1 :[3,4,2,1,5]
    // int N = 5;
    // int[] stages = {2,1,2,6,2,4,3,3};
    //Test2 :[4,1,2,3]
    // int N = 4;
    // int[] stages = {4,4,4,4,4};
    //Test3 :[4,1,2,3]
    int N = 4;
    int[] stages = {1,1,1};

    System.out.println(Arrays.toString(solution(N, stages)));
  }

  public static int[] solution(int N, int[] stages) {
    double[] answers = new double[N+1];

    int player = stages.length;

    for(int stage : stages){
      answers[stage-1] +=1;
    }

    Map<Integer, Double> maps = new HashMap<>();
    List<Double> list = new ArrayList<>();
    double a;
    for(int i=0; i<N; i++){
      if(player==0) a=0;
      else a = answers[i]/player; 
    
      list.add(a);
      maps.put(i, a);
      player -= (int)answers[i];
    }

    list.sort(Collections.reverseOrder());
    int[] result = new int[N];
    

    Loop1:
    for(int i=0; i<N; i++){
      double b = list.get(i);
      
      for(Map.Entry<Integer, Double> map : maps.entrySet()){
        if(b == map.getValue()){
          int n =map.getKey();
          result[i] = n+1;
          maps.remove(n);
          continue Loop1;
        }
      }
      result[i] = i+1;
    }


    return result;
  }
}
