package programmers;

import java.util.Arrays;

public class 행렬의_덧셈 {
  public static void main(String[] args) {
    //TEST1 : [[4,6],[7,9]]
    // int[][] arr1 = {{1,2},{2,3}};
    // int[][] arr2 = {{3,4},{5,6}};
    //TEST2 : [[4],[6]]
    int[][] arr1 = {{1},{2}};
    int[][] arr2 = {{3},{4}};
    System.out.println(Arrays.toString(solution(arr1, arr2)));
  }

  public static int[][] solution(int[][] arr1, int[][] arr2) {
    int[][] answer = new int[arr1.length][arr1[0].length];

    for(int i =0; i<arr1.length; i++){
      for(int j=0; j<arr1[i].length; j++){
        answer[i][j] = arr1[i][j] + arr2[i][j];
      }
    }
    return answer;
  }
}
