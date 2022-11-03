package bakjjun_codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1012 {
  static int[][] graph;
  static boolean[][] visited;
  static int[] dx = {1,0,-1,0};
  static int[] dy = {0,-1,0,1};
  static int m;
  static int n;
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int t = Integer.parseInt(br.readLine());
    
    for(int i=0; i<t; i++){
      st = new StringTokenizer(br.readLine());
      m = Integer.parseInt(st.nextToken());
      n = Integer.parseInt(st.nextToken());
      int k = Integer.parseInt(st.nextToken());
      graph = new int[m+1][n+1];
      visited = new boolean[m+1][n+1];

      for(int j=0; j<k; j++){
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        
        graph[a+1][b+1] = 1;
      }

      int cnt = 0;
      for(int j=1; j<m+1; j++){
        for(int l=1; l<n+1; l++){
          if(graph[j][l] == 1 && !visited[j][l]){
            cnt++;
            visited[j][l] = true;
            // dfs(j,l);
            bfs(j,l);
          }
        }
      }

      System.out.println(cnt);
    }
  }



  private static void bfs(int j, int l) {
    Queue<int[]> q = new LinkedList<>();
    q.offer(new int[]{j,l});

    while(!q.isEmpty()){
      int[] val = q.poll();
      int x = val[0];
      int y = val[1];

      for(int i=0; i<4; i++){
        int x2 = x + dx[i];
        int y2 = y + dy[i];

        if(x2>0 && y2>0 && x2<m+1 & y2<n+1 && !visited[x2][y2] && graph[x2][y2] == 1){
          visited[x2][y2] = true;
          q.offer(new int[]{x2,y2});
        }
      }
    }
  }



  // private static void dfs(int j, int l) {

  //   for(int i=0; i<4; i++){
  //     int a = j+dx[i];
  //     int b = l+dy[i];

  //     if(a>0 && b>0 && a<m+1 && b<n+1 && !visited[a][b] && graph[a][b] == 1){
  //       visited[a][b] = true;
  //       dfs(a, b);
  //     }
  //   }
  // }
}
