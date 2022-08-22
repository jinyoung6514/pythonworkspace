package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 같은_숫자는_싫어{
  public static void main(String[] args) {
    // int[] arr = {1,1,3,3,0,1,1};
    int[] arr = {4,4,4,3,3};
    System.out.println(Arrays.toString(solution(arr)));
  }

  public static int[] solution(int []arr) {

    List<Integer> ansList = new ArrayList<>();
    int cnt = 0;
    ansList.add(cnt++,arr[0]);
    for(int i=1; i<arr.length; i++){
      if(arr[i] == arr[i-1]){
        continue;
      }
      ansList.add(cnt++, arr[i]);
    }

    //array to int[]
    int[] answer = ansList.stream().mapToInt(Integer::intValue).toArray();

    return answer;
  }
}