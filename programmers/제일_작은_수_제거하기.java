package programmers;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class 제일_작은_수_제거하기 {
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
    List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
    
    list.remove(Integer.valueOf(Collections.min(list)));

    int[] answer = list.stream().mapToInt(Integer::intValue).toArray();
    return answer;
  }
}
