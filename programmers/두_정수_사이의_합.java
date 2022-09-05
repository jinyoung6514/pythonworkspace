package programmers;

public class 두_정수_사이의_합 {
  public static void main(String[] args) {
    //Test1 : 12
    int a = 3;
    int b = 5;

    System.out.println(solution(a, b));
  }

  public static long solution(int a, int b) {
    long answer = 0;
    if(a > b){
      int temp = a;
      a = b;
      b = temp;
    } 
    for(int i=a; i<=b; i++) answer+=i;
    return answer;
  }
}
