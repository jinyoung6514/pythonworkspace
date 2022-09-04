package programmers;

import java.util.Stack;

public class 다트_게임 {
  public static void main(String[] args) {
    //Test1 : 37
    // String dartResult = "1S2D*3T";
    //Test2 : 9
    // String dartResult = "1D2S#10S";
    //Test3 : 3
    // String dartResult = "1D2S0T";
    //Test4 : 23
    String dartResult = "1S*2T*3S";
    

    System.out.println(solution(dartResult));
  }

  //s,d,t,*,#
  public static int solution(String dartResult) {
    Stack<Integer> stack = new Stack<>();
    char[] dartArr = dartResult.toCharArray();
    
    int a=0;
    for(int i=0; i<dartArr.length; i++){
      switch(dartArr[i]){
        case 'S' :
          stack.push(a);
        break;
        
        case 'D' :
          stack.push(a*a);
        break;

        case 'T' :
          stack.push(a*a*a);
        break;

        case '*' :
          int temp = stack.pop()*2;
          if(!stack.isEmpty()) stack.push(stack.pop()*2);
          stack.push(temp);
        break;

        case '#' :
          stack.push(stack.pop()*-1);
        break;

        case '1' :
          if(dartArr[i+1] == '0'){
            a=10;
            i++;
          } 
          else a = dartArr[i] - '0';
        break;

        default :
        a = dartArr[i] -'0';
      }
    }

    int answer=0;
    while(!stack.isEmpty()) answer += stack.pop();


    return answer;
  }
}
