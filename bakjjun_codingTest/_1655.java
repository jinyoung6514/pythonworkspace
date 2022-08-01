import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class _1655{
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int N = Integer.parseInt(br.readLine());
    PriorityQueue<Integer> maxheap =  new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> minheap =  new PriorityQueue<>();
    for(int i=0; i<N; i++){
      int num = Integer.parseInt(br.readLine());
      
      if(maxheap.size() == minheap.size()){
        maxheap.add(num);
      }else{
        minheap.add(num);
      }

      if(!minheap.isEmpty()){
        if(maxheap.peek()>minheap.peek()){
          int t1 = minheap.poll();
          int t2 = maxheap.poll();
          minheap.add(t2);
          maxheap.add(t1);
        }
      }
      sb.append(maxheap.peek()).append("\n");
    }
    System.out.println(sb);
  }
}