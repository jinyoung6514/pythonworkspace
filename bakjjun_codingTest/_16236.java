package bakjjun_codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _16236 {
  static int n;
  static int[][] graph;
  static boolean[][] visited;
  static int[] dx = {-1,0,1,0};
  static int[] dy = {0,-1,0,1};
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    n = Integer.parseInt(br.readLine());

    graph = new int[n][n];
    visited = new boolean[n][n];
  
    for(int i=0; i<n; i++){
      st = new StringTokenizer(br.readLine());
      for(int j=0; j<n; j++){
        graph[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    for(int i=0; i<n; i++){
      for(int j=0; j<n; j++){
        if(graph[i][j] == 9) System.out.println(bfs(i, j));
      }
    }
  }

  private static int bfs(int a, int b) {
    int result = 0;
    visited[a][b] = true;
    graph[a][b] = 0;
    
    PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        if(o1[4]==o2[4]){
          if(o1[0]==o2[0]){
            return o1[1]-o2[1];
          }else{
            return o1[0]-o2[0];
          }
        }else{
          return o1[4]-o2[4];
        }
      }
    });

    //x좌표,y좌표,사이즈,먹은먹이,현재위치와 먹이까지의거리,먹이를 먹었는지여부
    q.offer(new int[]{a,b,2,0,0,0});

    while(!q.isEmpty()){
      int[] val = q.poll();
      int x = val[0];
      int y = val[1];

      for(int i=0; i<4; i++){
        int x2 = x + dx[i];
        int y2 = y + dy[i];

        if(x2<0 || x2>=n || y2<0 || y2>=n) continue;

        if(!visited[x2][y2] && graph[x2][y2] <= val[2]){

          //상어보다 물고기가 작은 경우
          if(graph[x2][y2] < val[2] && graph[x2][y2]!=0){
            result = val[4]+1;
            if(val[2] == val[3]+1){
              q.offer(new int[]{x2,y2,val[2]+1,0,result,1});    
            }else{
              q.offer(new int[]{x2,y2,val[2],val[3]+1,result,1});    
            }
          }

          visited[x2][y2] = true;
          q.offer(new int[]{x2,y2,val[2],val[3],val[4]+1,val[5]});    
        }
      }

      int[] reset = q.peek();
      if(!q.isEmpty() && reset[5]==1){
        //먹이를 찾았으니 전체 초기화작업
        q.clear();
        reset[5] = 0;
        q.offer(reset);
    
        //방문내역 초기화
        visited = new boolean[n][n];
        visited[reset[0]][reset[1]] = true;

        //먹이먹었으니 0으로 초기화
        graph[reset[0]][reset[1]] = 0;
      } 
    }

    return result;
  }
}
