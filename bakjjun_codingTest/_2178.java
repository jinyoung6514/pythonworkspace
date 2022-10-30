package bakjjun_codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _2178 {
  static int[][] check;
  static boolean[][] visited;
  static int[] dx = {1,0,-1,0};
  static int[] dy = {0,1,0,-1};
  static int n,m;//,min;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    visited = new boolean[n+1][m+1];
    check = new int[n+1][m+1];
    for(int i=1; i<n+1; i++){
      String a = br.readLine();
      for(int j=1; j<m+1; j++){
        check[i][j] = a.charAt(j-1)-48;
      }
    }

    // min = Integer.MAX_VALUE;
    // visited[1][1] = true;
    // dfs(1, 1, 1);
    // System.out.println(min);
    bfs(1,1);
    System.out.println(check[n][m]);
  }

  private static void bfs(int a, int b) {

    Queue<int[]> q = new LinkedList<>();
    q.offer(new int[]{a,b});
    
    while(!q.isEmpty()){

      int[] value = q.poll();
      int x1 = value[0];
      int y1 = value[1];
      visited[x1][y1] = true;

      if(x1 == n && y1 == m) break;

      for(int i=0; i<4; i++){
        int x2 = x1 + dx[i];
        int y2 = y1 + dy[i];

        if(x2>0 && y2>0 && x2<n+1 && y2<m+1 && check[x2][y2]==1 && !visited[x2][y2]){
          q.offer(new int[]{x2,y2});
          check[x2][y2] = check[x1][y1] + 1;
        }
      }
    }
  }

  

  //시간초과
  // private static void dfs(int a, int b, int count) {
  //   if(min<count) return;
  //   if(a == n && b == m){ 
  //     min = count; 
  //     return;
  //   }

  //   for(int i=0; i<4; i++){
  //     int x = a+dx[i];
  //     int y = b+dy[i];

  //     if(x>0 && y>0 && x<n+1 && y<m+1 && check[x][y]==1 && !visited[x][y]){
  //       visited[x][y] = true;
  //       dfs(x, y, count+1);
  //       visited[x][y] = false;
  //     }
  //   }
  // }
}
