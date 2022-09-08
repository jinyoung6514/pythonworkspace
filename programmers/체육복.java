package programmers;

import java.util.Arrays;

public class 체육복 {
  public static void main(String[] args) {
    //Test1 : 5
    // int n = 5;
    // int[] lost = {2,4};
    // int[] reserve = {1,3,5};
    //Test1 : 5
    // int n = 5;
    // int[] lost = {2,4};
    // int[] reserve = {3};
    //Test1 : 5
    int n = 3;
    int[] lost = {3};
    int[] reserve = {1};

    System.out.println(solution(n, lost, reserve));
  }

  public static int solution(int n, int[] lost, int[] reserve) {
    int[] arr = new int[n];
    Arrays.fill(arr, 1);
    
    for(int losts : lost){
      arr[losts-1] -= 1;
    }

    for(int reserves : reserve){
      arr[reserves-1] +=1;
    }

    int answer = 0;
    for(int i=0; i<n; i++){
      if(arr[i] >= 1){
        answer += 1;
      }else if(arr[i] == 0){
        if(i!=0 && arr[i-1] == 2){
          answer += 1;
        }else if(i!=n-1 && arr[i+1] == 2){
          arr[i+1] -= 1;
          answer += 1;
        }
      }
    }
    
    return answer;
  }
}
