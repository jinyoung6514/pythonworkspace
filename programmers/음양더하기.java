package programmers;

public class 음양더하기 {
  public static void main(String[] args) {
    //Test1 : 9
    // int[] absolutes = {4,7,12};
    // boolean[] signs = {true,false,true};
    //Test2 : 0
    int[] absolutes = {1,2,3};
    boolean[] signs = {false,false,true};
    System.out.println(solution(absolutes, signs));
  }

  public static int solution(int[] absolutes, boolean[] signs) {
    int sum=0;
    for(int i=0; i<absolutes.length; i++){
      sum += signs[i] ? absolutes[i] : -absolutes[i];
    }
    
    return sum;
  }
}
