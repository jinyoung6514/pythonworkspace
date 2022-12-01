package bakjjun_codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1389 {
  static int n;
  static int[][] graph;
  static boolean[] visited;
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    graph = new int[n+1][n+1];

    for(int i=0; i<m; i++){
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      graph[x][y] = graph[y][x] = 1;
    }

    int max = Integer.MAX_VALUE;
    int result = 0;
    for(int i=1; i<=n; i++){
      int x = bfs(i);
      if(x<max){
        max = x;
        result = i;
      }
    }
    System.out.println(result);
  }

  private static int bfs(int a) {
    int result=0;
    visited = new boolean[n+1];
    visited[a] = true;
    Queue<int[]> q = new LinkedList<>();
    q.offer(new int[]{a,0});

    while(!q.isEmpty()){
      int[] val = q.poll();
      int x = val[0];

      for(int i=1; i<=n; i++){
        if(graph[x][i] == 1 && !visited[i]){
          visited[i] = true;
          result += val[1]+1;
          q.offer(new int[]{i,val[1]+1});
        }
      }
    }

    return result;
  }
}
