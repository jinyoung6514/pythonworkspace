package bakjjun_codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;


public class _11286{
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2){
        //리턴값이 양수면 변경 아니면 가만히
        if(Math.abs(o1)>Math.abs(o2)){
          return 1;
        }else if(Math.abs(o1)==Math.abs(o2)){
          return o1-o2;
        }else{
          return -1;
        }
      }
    });
    
    for(int i=0; i<N; i++){
      int x = Integer.parseInt(br.readLine());
      if(x == 0){
        if(priorityQueue.size() == 0){
          sb.append(0+"\n");
        }else{
          sb.append(priorityQueue.poll()+"\n");
        }
      }else{
        priorityQueue.offer(x);
      }
    }
    System.out.println(sb);
  }
}