import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;
import java.util.Map;

public class _1302 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    Map<String,Integer> bookMaps = new TreeMap<>();
    for(int i=0; i<N; i++){
      String book = br.readLine();
      if(bookMaps.containsKey(book)){
        bookMaps.put(book, bookMaps.get(book)+1);
      }else{
        bookMaps.put(book, 1);
      }
    }

    String output="";
    int cnt=0;
    for(Map.Entry<String, Integer> bookMap : bookMaps.entrySet()){
      if(cnt < bookMap.getValue()){
        output = bookMap.getKey();
        cnt = bookMap.getValue();
      }
    }
    System.out.println(output);
  }
}
