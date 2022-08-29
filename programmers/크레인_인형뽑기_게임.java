package programmers;

import java.util.Stack;

public class 크레인_인형뽑기_게임 {
  public static void main(String[] args) {
    // Test1 : 4
    int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
    int[] moves = {1,5,3,5,1,2,1,4};

    System.out.println(solution(board, moves));
  }

  public static int solution(int[][] board, int[] moves) {
    Stack<Integer> stack = new Stack<>();
    int moveNum;
    int result = 0;
    for(int i : moves){
      moveNum = 0;
      for(int j=0; j<board.length; j++){
        //해당위치 값찾기
        if(board[j][i-1] !=0){
          moveNum = board[j][i-1];
          board[j][i-1] = 0;
          break;
        }
      }
  
      if(moveNum == 0) continue;
      if(stack.isEmpty()) stack.push(moveNum);
      else if(stack.peek() == moveNum){
        stack.pop();
        result+=1;
      }else{
        stack.push(moveNum);
      }
    }

    return result*2;
  }
}
