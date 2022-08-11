import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _5052 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());
    boolean check;
    
    StringBuilder sb = new StringBuilder();
    for(int i=0; i<t; i++){
      check = true;
      int n = Integer.parseInt(br.readLine());
      String[] phoneNum = new String[n];
      for(int j=0; j<n; j++){
        phoneNum[j] = br.readLine();
      }
      Arrays.sort(phoneNum);
      for(int j=1; j<n; j++){
        if(phoneNum[j].startsWith(phoneNum[j-1])){
          check = false;
          break;
        }
      }
      
      if(check){
        sb.append("YES\n");
      }else{
        sb.append("NO\n");
      }
    }
    System.out.println(sb);
  }
}
