package bakjjun_codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class _1715 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N =Integer.parseInt(br.readLine());
    int totCard = 0;
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    //모든 카드 뭉치 받기 완료
    for(int i=0; i<N; i++){
      int card = Integer.parseInt(br.readLine());
      minHeap.add(card);
    }
    
    while(minHeap.size() != 1){
      int t1 = minHeap.poll();
      int t2 = minHeap.poll();

      totCard = totCard + t1 + t2;
      minHeap.add(t1+t2);
    }

    System.out.println(totCard);
  }
}
