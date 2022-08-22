package programmers;

public class 최소직사각형 {
  public static void main(String[] args) {
    // int[][] sizes = {{60,50},{30,70},{60,30},{80,40}};  //4000
    // int[][] sizes = {{10,7},{12,3},{8,15},{14,7},{5,15}};  //120
    int[][] sizes = {{14,4},{19,6},{6,16},{18,7},{7,11}};  //133

    System.out.println(solution(sizes));
  }

  public static int solution(int[][] sizes) {
    
    int maxW = 0;
    int maxH = 0;

    for(int i=0; i<sizes.length; i++){
      int a = sizes[i][0];
      int b = sizes[i][1];
      if(a < b){
        int temp = a;
        a = b;
        b = temp;
      }

      if(a > maxW) maxW = a;
      if(b > maxH) maxH = b; 
    }
    
    int answer = maxW*maxH;
    return answer;
  }
}
