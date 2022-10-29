package bakjjun_codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1260 {
  static int[][] graph;
  static boolean[] visited;
  static Queue<Integer> q = new LinkedList<>();
  static StringBuilder sb = new StringBuilder();
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());  
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int v = Integer.parseInt(st.nextToken());

    visited = new boolean[n+1];
    graph = new int[n+1][n+1];
    for(int i=1; i<m+1; i++){
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      graph[x][y] = graph[y][x] = 1;
    }

    dfs(v);
    System.out.println(sb);
    sb.setLength(0);
    visited = new boolean[n+1];
    bfs(v);
    System.out.println(sb);
  }


  public static void dfs(int n){
    visited[n] = true;
    sb.append(n).append(" ");

    for(int i=0; i<graph[n].length; i++){
      if(!visited[i] && graph[n][i] == 1){
        dfs(i);
      }
    }
  }

  public static void bfs(int n){
    q.offer(n);
    visited[n] = true;

    while(!q.isEmpty()){
      int x = q.poll();
      sb.append(x).append(" ");
      
      for(int i=0; i<graph[x].length; i++){
        if(!visited[i] && graph[x][i] == 1){
          q.offer(i);
          visited[i] = true;
        }
      }
    }
  }

}




