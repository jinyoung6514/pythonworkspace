package bakjjun_codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _4963 {
  static int[][] graph;
  static boolean[][] visited;
  static int[] dx = {1,1,0,-1,-1,-1,0,1};
  static int[] dy = {0,1,1,1,0,-1,-1,-1};
  static int w,h;
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    String brStr;
    while(!(brStr = br.readLine()).equals("0 0")){
      st = new StringTokenizer(brStr);
      w = Integer.parseInt(st.nextToken());
      h = Integer.parseInt(st.nextToken());

      graph = new int[h][w];
      visited = new boolean[h][w];
      for(int i=0; i<h; i++){
        st = new StringTokenizer(br.readLine());
        for(int j=0; j<w; j++){
          graph[i][j] = Integer.parseInt(st.nextToken());
        }
      }

      int cnt=0;
      for(int i=0; i<h; i++){
        for(int j=0; j<w; j++){
          if(graph[i][j] == 1 && !visited[i][j]){
            cnt++;
            visited[i][j] = true;
            dfs(i,j);
          }
        }
      }
      
      System.out.println(cnt);
    }
  }

  private static void dfs(int a, int b) {
    for(int i=0; i<8; i++){
      int x = a + dy[i];
      int y = b + dx[i];

      if(x>=0 && y>=0 && x<h && y<w && !visited[x][y] && graph[x][y] == 1){
        visited[x][y] = true;
        dfs(x, y);
      }
    }
  }
}
