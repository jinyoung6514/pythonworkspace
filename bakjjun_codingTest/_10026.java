package bakjjun_codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _10026 {
  static String[][] graph;
  static boolean[][] visited1;
  static boolean[][] visited2;
  static int[] dx = {-1,0,1,0};
  static int[] dy = {0,1,0,-1};
  static int n;
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    n = Integer.parseInt(br.readLine());

    graph = new String[n][n];
    visited1 = new boolean[n][n];
    visited2 = new boolean[n][n];

    for (int i = 0; i < n; i++){
      st = new StringTokenizer(br.readLine());
      String lines = st.nextToken();
      for (int j = 0; j < n; j++){
        graph[i][j] = lines.substring(j, j+1);
      }
    }

    int cnt1=0;
    int cnt2=0;
    for (int i = 0; i < n; i++){
      for (int j = 0; j < n; j++){
        if(!visited1[i][j]){
          visited1[i][j] = true;
          bfs1(i,j,graph[i][j]);
          cnt1++;
        }

        if(!visited2[i][j]){
          visited2[i][j] = true;
          bfs2(i,j,graph[i][j]);
          cnt2++;
        }
      }
    }
    System.out.println(cnt1+" "+cnt2);
  }

  private static void bfs1(int a, int b, String c) {
    Queue<int[]> q = new LinkedList<>();
    q.offer(new int[]{a,b});

    while(!q.isEmpty()){
      int[] val = q.poll();
      int x = val[0];
      int y = val[1];

      for(int i=0; i<4; i++){
        int x2 = x + dx[i];
        int y2 = y + dy[i];

        if(x2>=0 && y2>=0 && x2<n && y2<n && !visited1[x2][y2] && graph[x2][y2].equals(c)){          
          visited1[x2][y2] = true;
          q.offer(new int[]{x2,y2});
        }
      }
      
    }
  }

  private static void bfs2(int a, int b, String c) {
    Queue<int[]> q = new LinkedList<>();
    q.offer(new int[]{a,b});
    boolean blue = false;
    if(c.equals("B")) blue= true;

    while(!q.isEmpty()){
      int[] val = q.poll();
      int x = val[0];
      int y = val[1];

      for(int i=0; i<4; i++){
        int x2 = x + dx[i];
        int y2 = y + dy[i];

        if(x2>=0 && y2>=0 && x2<n && y2<n && !visited2[x2][y2]){
          if(blue){
            if(graph[x2][y2].equals("B")){
              visited2[x2][y2] = true;
              q.offer(new int[]{x2,y2});
            }
          }else{
            if(graph[x2][y2].equals("G")||graph[x2][y2].equals("R")){
              visited2[x2][y2] = true;
              q.offer(new int[]{x2,y2});
            }
          }
        }          
      }
    }
  }
}
