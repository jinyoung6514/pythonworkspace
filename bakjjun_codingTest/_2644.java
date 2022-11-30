package bakjjun_codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _2644 {
  static int n;
  static int[][] graph;
  static boolean[] visited;
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(br.readLine());

    graph = new int[n+1][n+1];
    visited = new boolean[n+1];
    for(int i=0; i<m; i++){
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      graph[x][y] = graph[y][x] = 1;
    }

    bfs(a,b);
  }

  private static void bfs(int a, int b) {
    Queue<int[]> q = new LinkedList<int[]>();
    q.offer(new int[]{a,0});
    visited[a] = true;

    while(!q.isEmpty()){
      int[] val = q.poll();
      int x = val[0];

      if(x == b){
        System.out.println(val[1]);
        System.exit(0);
      }
      
      for(int i=1; i<n+1; i++){
        if(graph[x][i] == 1 && !visited[i]){
          visited[i] = true;
          q.offer(new int[]{i,val[1]+1});
        }
      }
    }

    System.out.println(-1);
  }
}
