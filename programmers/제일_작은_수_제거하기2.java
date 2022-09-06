package programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 제일_작은_수_제거하기2 {
  public static void main(String[] args) {
    // Test1 : [4,3,2]
    int[] arr = { 4, 3, 2, 1 };

    System.out.println(Arrays.toString(solution(arr)));
  }

  public static int[] solution(int[] arr) {
    if(arr.length==1){
      arr[0] = -1;
      return arr;
    }

    //key : arr값, value : 순서
    Map<Integer,Integer> maps = new HashMap<>(){{
      for(int i=0; i<arr.length; i++){
        put(arr[i],i);
      }
    }};

    Arrays.sort(arr);

    //map의 value값을 서로 비교해서 maps.get[arr[0]] 보다 큰 value를 가진애들은 전체 value에서 -1을 해야한다.
    int temp = maps.remove(arr[0]);
    int[] answer = new int[arr.length-1];
    for(Map.Entry<Integer,Integer> map : maps.entrySet()){
      if(map.getValue() > temp) answer[map.getValue()-1] = map.getKey();
      else answer[map.getValue()] = map.getKey();
    }

    return answer;
  }
}
