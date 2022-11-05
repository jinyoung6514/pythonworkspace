package bakjjun_codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _11724{
  static int[][] graph;
  static boolean[] visited;
  static int n;
  static int m;
  public static void main(String[] args) throws IOException{
    BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    graph = new int[n+1][n+1];
    visited = new boolean[n+1];
    for(int i=0; i<m; i++){
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      graph[a][b] = graph[b][a] = 1;
    }

    int count = 0;
    for(int i=1; i<n+1; i++){
      for(int j=1; j<n+1; j++){
        if(graph[i][j] == 1 && !visited[i]){
          count++;
          visited[i] = true;
          // dfs(i);
          bfs(i);
        }
      }
    }
    for(int i=1; i<n+1; i++){
      if(!visited[i]) count++;
    }
    System.out.println(count);
  }

  private static void bfs(int a) {
    Queue<Integer> q = new LinkedList<>();
    q.offer(a);

    while(!q.isEmpty()){
      int x = q.poll();

      for(int i=1; i<n+1; i++){
        if(graph[x][i] == 1 && !visited[i]){
          visited[i] = true;
          q.offer(i);
        }
      }
    }
  }

  

  // private static void dfs(int a) {
  //   for(int i=1; i<n+1; i++){
  //     if(graph[a][i] == 1 && !visited[i]){
  //       visited[i] = true;
  //       dfs(i);
  //     }
  //   }
  // }
}