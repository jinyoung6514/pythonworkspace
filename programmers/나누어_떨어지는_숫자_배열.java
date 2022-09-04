package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 나누어_떨어지는_숫자_배열 {
  public static void main(String[] args) {
    //Test1 : 5,10
    // int[] arr = {5,9,7,10};
    // int divisor = 5;
    //Test2 : 1,2,3,36
    int[] arr = {2,36,1,3};
    int divisor = 1;

    System.out.println(Arrays.toString(solution(arr, divisor)));
  }

  public static int[] solution(int[] arr, int divisor) {
    List<Integer> list = new ArrayList<>();
    for(int num : arr){
      if(num%divisor==0) list.add(num);
    }

    if(list.isEmpty()) list.add(-1);
    else{
      Collections.sort(list);
    }

    return list.stream().mapToInt(Integer::intValue).toArray();
  }
}
