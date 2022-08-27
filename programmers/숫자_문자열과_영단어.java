package programmers;

public class 숫자_문자열과_영단어 {
  public static void main(String[] args) {
    //Test1 : 1478
    // String s = "one4seveneight";
    //Test2 : 234567
    // String s = "23four5six7";
    //Test3 : 234567
    // String s = "2three45sixseven";
    //Test4 : 123
    String s = "123";

    System.out.println(solution(s));
  }

  public static int solution(String s) {
    StringBuilder sb = new StringBuilder();
    String[] nums = {"zero","one","two","three","four","five","six","seven","eight","nine"};
    String num="";
    for(int i=0; i<s.length(); i++){
      char sChar = s.charAt(i);
      if(sChar>='0' && sChar<='9'){
        sb.append(sChar);
      }else{
        num += sChar;
      }
      if(num.length()>=3){
        for(int j=0; j<nums.length; j++){
          if(num.equals(nums[j])){
            num="";
            sb.append(j);
            break;
          }
        }
      }
    }
  
    return Integer.parseInt(sb.toString());
  }
}