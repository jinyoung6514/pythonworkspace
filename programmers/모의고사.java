package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 모의고사 {
  public static void main(String[] args) {
    //Test1 : [1]
    int[] answers = {1,2,3,4,5};
    //Test2 : [1,2,3]
    // int[] answers = {1,3,2,4,2};

    System.out.println(Arrays.toString(solution(answers)));
  }

  public static int[] solution(int[] answers) {
    int[] answer = new int[3];
    int[] math1 = {1,2,3,4,5};
    int[] math2 = {2,1,2,3,2,4,2,5};
    int[] math3 = {3,3,1,1,2,2,4,4,5,5};
    
    for(int i=0 ;i<answers.length; i++){
      if(math1[i%5]==answers[i]) answer[0]++;
      if(math2[i%8]==answers[i]) answer[1]++;
      if(math3[i%10]==answers[i]) answer[2]++;
    }

    int max = answer[0];
    for(int a : answer){
      if(max < a) max = a;
    }

    //맥스값을 찾고 해당값과 같은 인덱스를 add한다.
    List<Integer> list = new ArrayList<>();
    for(int i=0; i<3; i++){
      if(answer[i] == max) list.add(i+1);
    }

    answer = new int[list.size()];
    for(int i=0; i<list.size(); i++){
      answer[i] = list.get(i);
    }

    // answer = list.stream().mapToInt(Integer::intValue).toArray();

    return answer;
  }
}
