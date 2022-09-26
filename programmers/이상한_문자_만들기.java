package programmers;

public class 이상한_문자_만들기 {
  public static void main(String[] args) {
    //Test :"   TrY    HeLlO     WoRlD   "
    String s = "   try    hello     world   ";

    System.out.println(solution(s));  
  }

  public static String solution(String s) {
    StringBuffer sb = new StringBuffer();
    int count = 0;
    for(int i=0; i<s.length(); i++){
      char c = s.charAt(i);
      if(c == ' '){
        count=0;
        sb.append(' ');
        continue;
      }else{
        if(count%2==0){
          sb.append(Character.toUpperCase(c));
        }else{ 
          sb.append(Character.toLowerCase(c));
        }
        count++;
      }
    }
    
    return sb.toString();
  }
  
}

