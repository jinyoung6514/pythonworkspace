import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _1935 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    String inputs = br.readLine();
    
    double[] value = new double[91];
    int cnt=65;
    for(int i=0; i<N; i++){
      value[cnt++] = Integer.parseInt(br.readLine());
    }
    
    Stack<Double> stack = new Stack<>();
    for(int i=0; i<inputs.length(); i++){
      char input = inputs.charAt(i);
      if(input >= 'A' && input <='Z'){
        stack.push(value[input]);
      }else{
        Double data = stack.pop();
        if(input == '+'){
          stack.push(stack.pop() + data);
        }else if(input == '-'){
          stack.push(stack.pop() - data);
        }else if(input == '*'){
          stack.push(stack.pop() * data);
        }else if(input == '/'){
          stack.push(stack.pop() / data);
        }
      } 
    }

    System.out.printf("%.2f",stack.pop());
  }
}
