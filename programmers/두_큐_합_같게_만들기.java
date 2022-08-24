package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class 두_큐_합_같게_만들기{
  public static void main(String[] args) {
    //Test1 : 2
    // int[] queue1 = {3,2,7,2};
    // int[] queue2 = {4,6,5,1};
    //Test2 : 7
    // int[] queue1 = {1,2,1,2};
    // int[] queue2 = {1,10,1,2};
    //Test3 : -1
    int[] queue1 = {1,1,1,8,10,9};
    int[] queue2 = {1,1,1,1,1,1};
    System.out.println(solution(queue1, queue2));
  }

  public static int solution(int[] queue1, int[] queue2) {
    Queue<Integer> que1 = new LinkedList<>();
    Queue<Integer> que2 = new LinkedList<>();
    long sum = 0;
    long que1Sum=0;
    long que2Sum=0;
    
    //큐로 옮기기
    for(int i=0; i<queue1.length; i++){
      que1.add(queue1[i]);
      que2.add(queue2[i]);
      que1Sum += queue1[i];
      que2Sum += queue2[i];
    }
    sum = que1Sum+que2Sum;
    //합이 홀수면 -1리턴
    if(sum%2==1){
      return -1;
    }

    int count=0;
    while(count != (queue1.length+queue2.length)*2){
      if(que1Sum == que2Sum){
        return count;
      }else if(que1Sum>que2Sum){
        int temp = que1.poll();
        que1Sum -= temp;
        que2Sum += temp;
        count++;
        que2.offer(temp);
      }else{
        int temp = que2.poll();
        que2Sum -= temp;
        que1Sum += temp;
        count++;
        que1.offer(temp);
      }
      System.out.println(count);
      System.out.println(que1Sum);
      System.out.println(que2Sum);
      System.out.println();
    }

    return -1;
  }
}