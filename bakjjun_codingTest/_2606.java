package bakjjun_codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _2606 {
  static int[][] graph;
  static boolean[] visited;
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int com = Integer.parseInt(br.readLine());
    int con = Integer.parseInt(br.readLine());

    graph = new int[com+1][com+1];
    visited = new boolean[com+1];
    for(int i=0; i<con; i++){
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());

      graph[x][y] = graph[y][x] = 1;
    }

    visited[1] = true;
    // dfs(1);
    bfs(1);
    int count = 0;
    for(int i=2; i<com+1; i++){
      if(visited[i]) count++;
    }

    System.out.println(count);
    
  }
  private static void bfs(int n) {
    Queue<Integer> q = new LinkedList<>();
    q.offer(n);
    
    while(!q.isEmpty()){
      int x = q.poll();

      for(int i=1; i<graph[x].length; i++){
        if(graph[x][i] == 1 && !visited[i]){
          visited[i] = true;
          q.offer(i);
        }
      }
    }
  }

  // private static void dfs(int n) {
    
  //   for(int i=1; i<graph[n].length; i++){
  //     if(graph[n][i] == 1 && !visited[i]){
  //       visited[i] = true;
  //       dfs(i);
  //     }
  //   }
  // }
}
