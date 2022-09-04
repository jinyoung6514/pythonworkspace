package programmers;

import java.util.Arrays;

public class 비밀지도 {
  public static void main(String[] args) {
    // Test1 : ["#####","# # #", "### #", "# ##", "#####"]
    int n = 5;
    int[] arr1 = { 9, 20, 28, 18, 11 };
    int[] arr2 = { 30, 1, 21, 17, 28 };

    // Test2 : ["######", "### #", "## ##", " #### ", " #####", "### # "]
    // int n = 6;
    // int[] arr1 = {46, 33, 33 ,22, 31, 50};
    // int[] arr2 = {27 ,56, 19, 14, 14, 10};

    System.out.println(Arrays.toString(solution(n, arr1, arr2)));
  }

  public static String[] solution(int n, int[] arr1, int[] arr2) {
    String[] answerArr = new String[n];
    
    String row1,row2;
    for(int i=0; i<n; i++){
      row1 = String.format("%0"+n+"d",Long.parseLong(Integer.toBinaryString(arr1[i])));
      row2 = String.format("%0"+n+"d",Long.parseLong(Integer.toBinaryString(arr2[i])));

      String answer="";
      for(int j=0; j<n; j++){
        if(row1.charAt(j)=='1' || row2.charAt(j)=='1') answer+='#';
        else answer += ' '; 
      }
      answerArr[i] = answer;
    }

    return answerArr;
  }
}
