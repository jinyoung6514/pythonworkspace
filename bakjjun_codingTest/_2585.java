package bakjjun_codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _2585 {
  static int m,n;
  static int[][] graph;
  static boolean[][] visited;
  static int[] dx = {-1,0,1,0};
  static int[] dy = {0,1,0,-1};
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    m = Integer.parseInt(st.nextToken());
    n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    graph = new int[m][n];
    visited = new boolean[m][n];
    for(int i=0; i<k; i++){
      st = new StringTokenizer(br.readLine());
      int x1 = Integer.parseInt(st.nextToken());
      int y1 = Integer.parseInt(st.nextToken());
      int x2 = Integer.parseInt(st.nextToken());
      int y2 = Integer.parseInt(st.nextToken());
      for(int j=x1; j<x2; j++){
        for(int l=y1; l<y2; l++){
          graph[l][j] = 1;
        }
      }
    }

    ArrayList<Integer> list = new ArrayList<>();
    for(int i=0; i<m; i++){
      for(int j=0; j<n; j++){
        if(graph[i][j] == 0 && !visited[i][j]){
          list.add(bfs(i,j));
        }
      }
    }

    list.sort(Comparator.naturalOrder());
    System.out.println(list.size());
    for(int i=0; i<list.size(); i++){
      System.out.print(list.get(i) + " ");
    }
  }

  private static int bfs(int a, int b) {
    int cnt=1;
    visited[a][b] = true;
    Queue<int[]> q = new LinkedList<>();
    q.offer(new int[]{a,b});

    while(!q.isEmpty()){
      int[] val = q.poll();
      int x = val[0];
      int y = val[1];

      for(int i=0; i<4; i++){
        int x2 = x + dx[i];
        int y2 = y + dy[i];

        if(x2<0 || x2>=m || y2<0 || y2>=n) continue;

        if(graph[x2][y2] == 0 && !visited[x2][y2]){
          cnt++;
          visited[x2][y2] = true;
          q.offer(new int[]{x2,y2});
        }
      }
    }

    return cnt;
  }
}
