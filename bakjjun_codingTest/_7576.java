package bakjjun_codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _7576 {
  static int m,n;
  static int[][] graph;
  static boolean[][] visited;
  static int[] dx = {1,0,-1,0};
  static int[] dy = {0,1,0,-1};
  static Queue<int[]> q = new LinkedList<>();
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    m = Integer.parseInt(st.nextToken());
    n = Integer.parseInt(st.nextToken());

    graph = new int[n][m];
    visited = new boolean[n][m];
    for(int i=0; i<n; i++){
      st = new StringTokenizer(br.readLine());
      for(int j=0; j<m; j++){
        graph[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    for(int i=0; i<n; i++){
      for(int j=0; j<m; j++){
        if(graph[i][j]==1 && !visited[i][j]){
          visited[i][j] = true;
          q.offer(new int[]{i,j});
        }
      }
    }
    bfs();
    int day = 0;
    for(int i=0; i<n; i++){
      for(int j=0; j<m; j++){      
        if(graph[i][j]==0){
          System.out.println(-1);
          return;
        }else if(graph[i][j]==-1) continue;

        if(day<graph[i][j]){
          day = graph[i][j];
        }
      }
    }
    System.out.println(day-1);
  }

  private static void bfs() {
    while(!q.isEmpty()){
      int val[] = q.poll();
      int x = val[0];
      int y = val[1];
      for(int i=0; i<4; i++){
        int x2 = x + dy[i];
        int y2 = y + dx[i];
  
        if(x2>=0 && y2>=0 && x2<n && y2<m && !visited[x2][y2] && graph[x2][y2] == 0){
          visited[x2][y2] = true;
          graph[x2][y2] = graph[x][y]+1;
          q.offer(new int[]{x2,y2});
        }
      }
    }
  }
}
