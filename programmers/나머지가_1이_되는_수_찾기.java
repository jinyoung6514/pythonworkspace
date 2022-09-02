package programmers;

public class 나머지가_1이_되는_수_찾기{
  public static void main(String[] args) {
    //Test1 : 3
    int n = 10;
    //Test2 : 11
    // int n = 12;

    System.out.println(solution(n));
  }
  
  public static int solution(int n) {
    int x=0;
  
    for(int i=2; i<n; i++){
      if(n%i==1){
        x = i;
        break;
      }
    }

    return x;
  } 
}