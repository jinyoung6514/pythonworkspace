package programmers;

import java.util.Arrays;

public class 예산 {
  public static void main(String[] args) {
    // Test1 : 3
    // int[] d = {1,5,2,5,4};
    // int budget = 9;
    // Test1 : 4
    int[] d = {2,2,3,3};
    int budget = 10;

    System.out.println(solution(d, budget));
  }

  public static int solution(int[] d, int budget) {
    int answer = 0;
    Arrays.sort(d);
    int sum=0;
    for(int money : d){
      sum+=money;
      if(sum>budget){
        break;
      }
      answer++;
    }

    return answer;
  }
}
