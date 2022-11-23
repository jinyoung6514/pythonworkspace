package bakjjun_codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _2206 {
  static int n,m;
  static int[][] graph;
  static int[][] result;
  static boolean[][][] visited;
  static int[] dx = {-1,0,1,0};
  static int[] dy = {0,1,0,-1};
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    graph = new int[n][m];
    result = new int[n][m];
    visited = new boolean[n][m][2];

    for(int i=0; i<n; i++){
      st = new StringTokenizer(br.readLine());
      String lines = st.nextToken();
      for(int j=0; j<m; j++){
        graph[i][j] = lines.charAt(j) -'0';
      }
    }

    bfs();

    System.out.println(-1);
  }

  private static void bfs() {
    visited[0][0][0] = true;
    visited[0][0][1] = true;
    result[0][0] = 1;
    Queue<int[]> q = new LinkedList<>();
    q.offer(new int[]{0,0,0});

    while(!q.isEmpty()){
      int[] val = q.poll();
      int x = val[0];
      int y = val[1];

      if(x == n-1 && y ==m-1){
        System.out.println(result[x][y]);
        System.exit(0);
      }

      for(int i=0; i<4; i++){
        int x2 = x + dx[i];
        int y2 = y + dy[i];

        if(x2<0 || x2>=n || y2<0 || y2>=m) continue;

        //길을 만날 경우
        if(graph[x2][y2] == 0){
          if(!visited[x2][y2][val[2]]){
            visited[x2][y2][val[2]] = true;
            result[x2][y2] = result[x][y] + 1;
            q.offer(new int[]{x2,y2,val[2]});
          }

        //벽을 만났을 떄
        }else if(graph[x2][y2]==1){
          //벽을 부시고 온 경우
          if(val[2] == 1) continue;
          //벽을 안부시고 온 경우
          else{
            visited[x2][y2][1] = true;
            result[x2][y2] = result[x][y] + 1;
            q.offer(new int[]{x2,y2,1});
          }
        }
      }
    }
  }
}
