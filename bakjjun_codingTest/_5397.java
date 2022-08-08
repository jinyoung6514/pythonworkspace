import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _5397 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());
    Stack<Character> stack1 = new Stack<>();
    Stack<Character> stack2 = new Stack<>();
    StringBuilder sb;

    for(int i=0; i<t; i++){
      stack1.clear();
      stack2.clear();
      String input = br.readLine();
      for(int j=0; j<input.length(); j++){
        char inputChar = input.charAt(j);
        if(inputChar == '<'){
          if(stack1.isEmpty()){
            continue;
          }else{
            stack2.push(stack1.pop());
          }
        }else if(inputChar == '>'){
          if(stack2.isEmpty()){
            continue;
          }else{
            stack1.push(stack2.pop());
          }
        }else if(inputChar == '-'){
          if(stack1.isEmpty()){
            continue;
          }else{
            stack1.pop();
          }
        }else{
          stack1.push(inputChar);
        }
      }

      while(!stack2.isEmpty()){
        stack1.push(stack2.pop());
      }

      sb = new StringBuilder();
      for(int j=0; j<stack1.size(); j++){
        sb.append(stack1.get(j));
      }
      System.out.println(sb);
    }
  }
}
