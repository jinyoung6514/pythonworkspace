package bakjjun_codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _9461 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());

    for (int i = 0; i < t; i++) {
      int n = Integer.parseInt(br.readLine());
      Long[] triangle;
      if(n<6) triangle = new Long[6];
      else triangle = new Long[(n+1)];
  
      triangle[1] = 1L;
      triangle[2] = 1L;
      triangle[3] = 1L;
      triangle[4] = 2L;
      triangle[5] = 2L;
      for (int j = 6; j <= n; j++) {
        triangle[j] = triangle[j-1] + triangle[j-5];
      }
      
      System.out.println(triangle[n]);
    }
  }
}
