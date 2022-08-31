package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class 두_개_뽑아서_더하기 {
  public static void main(String[] args) {
    // Test1 : 2,3,4,5,6,7
    // int[] numbers = { 2, 1, 3, 4, 1 };
    // Test2 : 2,5,7,9,12
    int[] numbers = {5,0,2,7};

    System.out.println(Arrays.toString(solution(numbers)));
  }

  public static int[] solution(int[] numbers) {
    List<Integer> list = new ArrayList<>();

    for(int i=0; i<numbers.length; i++){
      for(int j=i+1; j<numbers.length; j++){
        list.add(numbers[i]+numbers[j]);
      }
    }
    //list 중복제거);
    list = list.stream().distinct().collect(Collectors.toList());
    
    int[] answer = list.stream().mapToInt(Integer::intValue).toArray();
    Arrays.sort(answer);

    return answer;
  }
}
