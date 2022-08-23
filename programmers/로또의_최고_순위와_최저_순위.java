package programmers;

import java.util.Arrays;

public class 로또의_최고_순위와_최저_순위 {
  public static void main(String[] args) {
    //Test1 : [3,5]
    // int[] lottos = {44,1,0,0,31,25};
    // int[] win_nums = {31,10,45,1,6,19};
    //Test2 : [1,6]
    // int[] lottos = {0,0,0,0,0,0};
    // int[] win_nums = {38,19,20,40,15,25};
    //Test3 : [1,1]
    // int[] lottos = {45,4,35,20,3,9};
    // int[] win_nums = {20,9,3,45,4,35};
    //Test4 : [6,6]
    int[] lottos = {45,4,35,20,3,9};
    int[] win_nums = {1,2,5,7,8,10};
    System.out.println(Arrays.toString(solution(lottos, win_nums)));
  }

  public static int[] solution(int[] lottos, int[] win_nums) {
    int count = 0;
    int zero = 0;
    
    Loop1 :
    for(int i : lottos){
      if(i==0){
        zero+=1;
        continue; 
      }
      for(int j : win_nums){
        if(i==j){
          count += 1;
          continue Loop1;
        }
      }
    }

    int[] answer = {7-zero-count==7 ? 6 : 7-zero-count,count==0 ? 6 : 7-count};
    return answer;
  }
}
