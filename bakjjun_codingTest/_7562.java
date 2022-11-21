package bakjjun_codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _7562 {
  static int[][] graph;
  static boolean[][] visited;
  static int[] dx = {-2,-2,-1,1,2,2,1,-1};
  static int[] dy = {-1,1,2,2,1,-1,-2,-2};
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int t = Integer.parseInt(br.readLine());

    for(int i=0; i<t; i++){
      int size = Integer.parseInt(br.readLine());
      graph = new int[size][size];
      visited = new boolean[size][size];

      
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());

      st = new StringTokenizer(br.readLine());
      int x2 = Integer.parseInt(st.nextToken());
      int y2 = Integer.parseInt(st.nextToken());

      bfs(x,y,size,x2,y2);

      System.out.println(graph[x2][y2]);
    }
  }

  private static void bfs(int a, int b, int n, int a2, int b2) {
    visited[a][b] = true;
    Queue<int[]> q = new LinkedList<>();
    q.offer(new int[]{a,b});

    while(!q.isEmpty()){
      int[] val = q.poll();
      int x = val[0];
      int y = val[1];

      if(x==a2 && y==b2) break;

      for(int i=0; i<8; i++){
        int x2 = x + dx[i];
        int y2 = y + dy[i];

        if(x2>=0 && y2>=0 && x2<n && y2<n && !visited[x2][y2]){
          visited[x2][y2] = true;
          graph[x2][y2] = graph[x][y] + 1;
          q.offer(new int[]{x2,y2});
        }
      }
    }
  }
}

