package bakjjun_codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _11725 {
  // static int[][] graph;
  static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
  static boolean[] visited;
  static int[] root;
  static int n;
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    n = Integer.parseInt(br.readLine());

    for(int i=0; i<n+1; i++){
      graph.add(new ArrayList<Integer>());
    }

    visited = new boolean[n+1];
    root = new int[n+1];
    for(int i=0; i<n-1; i++){
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      graph.get(x).add(y);
      graph.get(y).add(x);
    }

    dfs(1);

    for (int i = 2; i < n+1; i++) {
      System.out.println(root[i]);
    }
  }

  private static void dfs(int a) {
    
    for(int i=0; i<graph.get(a).size(); i++){
      int x = graph.get(a).get(i);
      if(!visited[x]){
        visited[x] = true;
        root[x] = a;
        dfs(x);
      }
    }
  }
}
