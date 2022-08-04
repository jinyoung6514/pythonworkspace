import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _17413 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input = br.readLine();
    Stack<Character> stack = new Stack<>();
    StringBuilder sb = new StringBuilder();

    for(int i=0; i<input.length(); i++){
      if(input.charAt(i) == '<'){
        if(!stack.isEmpty()){
          while(!stack.isEmpty()){
            sb.append(stack.pop());
          } 
        }
        while(input.charAt(i) != '>'){
          sb.append(input.charAt(i));
          i++;
        }
        sb.append(input.charAt(i));
      }else if(input.charAt(i) == ' '){
        while(!stack.isEmpty()){
          sb.append(stack.pop());
        }
        sb.append(' ');
      }else if(i == input.length()-1 && input.charAt(i) != '>'){
        stack.push(input.charAt(i));
        while(!stack.isEmpty()){
          sb.append(stack.pop());
        }
      }else{
        stack.push(input.charAt(i));
      }
    }
    System.out.println(sb);
  }
}
