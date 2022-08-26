package programmers;

public class 신규_아이디_추천 {
  public static void main(String[] args) {
    //Test1 : "bat.y.abcdefghi"
    // String new_id = "...!@BaT#*..y.abcdefghijklm";
    //Test2 : "z--"
    // String new_id = "z-+.^.";
    //Test3 : "aaa"
    String new_id = "=.=";
    //Test4 : "123_.def"
    // String new_id = "123_.def";
    //Test5 : "abcdefghijklmn"
    // String new_id = "abcdefghijklmn.p";

    System.out.println(solution(new_id));
  }

  public static String solution(String new_id) {
    new_id = level12(new_id);
    new_id = level34(new_id);
    new_id = level567(new_id);

    return new_id;
  }

  public static String level12(String new_id){
    String answer="";
    for(int i=0; i<new_id.length(); i++){
      char a = new_id.charAt(i);
      //level1
      a = Character.toLowerCase(a);
      //level2
      if((a>='a' && a<= 'z') || (a>='0' && a<= '9') || a=='-' || a=='_' || a== '.'){
        answer += a;
      }
    }
    return answer;
  }

  public static String level34(String new_id){
    String answer="";
    for(int i=0; i<new_id.length()-1; i++){
      char a = new_id.charAt(i);
      if(a=='.'){
        char aNext = new_id.charAt(i+1);
        if(aNext=='.'){
          continue;
        }
      }
      answer += a;
    }
    answer += new_id.charAt(new_id.length()-1);

    char startChar = new_id.charAt(0);
    if(startChar=='.') answer=answer.substring(1);
    answer = removeLastChar(answer);
    return answer;
  }

  public static String level567(String new_id){
    if(new_id.length()==0) new_id="a";
    if(new_id.length()>15){
      new_id = new_id.substring(0,15);
      new_id = removeLastChar(new_id);
    }else if(new_id.length()<3){
      while(new_id.length()!=3){
        new_id += new_id.charAt(new_id.length()-1);
      }
    }
    return new_id;
  }

  public static String removeLastChar(String new_id){
    if(new_id.length()==0) return "";
    
    char endChar = new_id.charAt(new_id.length()-1);
    if(endChar=='.') new_id = new_id.substring(0,new_id.length()-1);

    return new_id;
  }
}
