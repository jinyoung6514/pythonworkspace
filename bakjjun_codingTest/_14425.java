import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _14425 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int tot=0;
    
    String[] S = new String[N];
    for(int i=0; i<N; i++){
      S[i] = br.readLine();
    }

    for(int i=0; i<M; i++){
      String input = br.readLine();
      for(int j=0; j<N; j++){
        if(S[j].equals(input)){
          tot++;
          break;
        }
      }
    }
    System.out.println(tot);
  }
}
