package bakjjun_codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _7569 {
  static int[][][] graph;
  static boolean[][][] visited;
  static Queue<int[]> q = new LinkedList<>();
  static int[] dx = {0,1,0,-1,0,0};
  static int[] dy = {1,0,-1,0,0,0};
  static int[] dz = {0,0,0,0,1,-1};
  static int h;
  static int n;
  static int m;
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    m = Integer.parseInt(st.nextToken());
    n = Integer.parseInt(st.nextToken());
    h = Integer.parseInt(st.nextToken());

    graph = new int[h][n][m];
    visited = new boolean[h][n][m];
    for(int i=0; i<h; i++){
      for(int j=0; j<n; j++){
        st = new StringTokenizer(br.readLine());
        for(int k=0; k<m; k++){
          graph[i][j][k] = Integer.parseInt(st.nextToken());
        }
      }
    }

    
    
    for(int i=0; i<h; i++){
      for(int j=0; j<n; j++){
        for(int k=0; k<m; k++){
          if(graph[i][j][k] == 1){
            visited[i][j][k] = true;
            q.offer(new int[]{i,j,k});
          }
        }
      }
    }

    bfs();

    int max = 1;
    boolean check = true;
    LOOP1:
    for(int i=0; i<h; i++){
      for(int j=0; j<n; j++){
        for(int k=0; k<m; k++){
          if(graph[i][j][k] == 0){
            check = false;
            break LOOP1;  
          }

          if(max<graph[i][j][k]){
            max = graph[i][j][k];
          }
        }
      }
    }

    System.out.println(check ? max-1 : -1);
  }

  private static void bfs() {
    
    while(!q.isEmpty()){
      int[] val = q.poll();
      int x = val[0];
      int y = val[1];
      int z = val[2];

      for(int i=0; i<6; i++){
        int x2 = x+dz[i];
        int y2 = y+dy[i];
        int z2 = z+dx[i];

        if(x2>=0 && y2>=0 && z2>=0 && x2<h && y2<n && z2<m &&!visited[x2][y2][z2] && graph[x2][y2][z2] == 0){
          visited[x2][y2][z2] = true;
          graph[x2][y2][z2] = graph[x][y][z]+1;
          q.offer(new int[]{x2,y2,z2});
        }
      }
    }
  }
}
