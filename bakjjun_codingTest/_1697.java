package bakjjun_codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1697 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    Queue<Integer> q = new LinkedList<>();
    int[] graph = new int[200002];
    boolean[] visited = new boolean[200002];
    graph[n] = 1;
    q.offer(n);
    int[] dx = {1, -1, 2};
    visited[n] = true;
    while(!q.isEmpty()){
      int a = q.poll();

      if(a==k){
        break;
      }

      for(int i=0; i<3; i++){
        int x;
        if(i==2) x = a*dx[i];
        else x = a + dx[i];

        if(x>=0 && x<200002 && !visited[x]){
          graph[x] = graph[a]+1;
          visited[x] = true;
          q.offer(x);
        }
      }
    }

    System.out.println(graph[k]-1);
  }
}
