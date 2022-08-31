package programmers;

public class 삼진법_뒤집기 {
  public static void main(String[] args) {
    //Test1 : 7
    // int n = 45;
    //Test2 : 229
    // int n = 125;
    int n = 100000000;
    System.out.println(solution(n));
  }

  public static long solution(int n) {
    if(n==0) return 0;
    int size = 0;
    for(int i=0; i<=n; i++){
      if(n<(int)Math.pow(3, i)){
        size = i;
        break;
      }
    }

    StringBuilder sb = new StringBuilder();
    for(int i=0; i<size; i++){
      int temp = (int) Math.pow(3, size-i-1);
      sb.append(n/temp);
      n = n%temp;
    }

    sb.reverse(); //0021
  
    String binaryString = Long.parseLong(sb.toString())+""; //21
    long answer = Long.parseLong(binaryString,3);
    
    return answer;
  }
}
