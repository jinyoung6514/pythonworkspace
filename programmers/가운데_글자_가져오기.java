package programmers;

public class 가운데_글자_가져오기 {
  public static void main(String[] args) {
    // Test1 : "c"
    // String s = "abced";
    // Test2 : "we"
    String s = "qwer";

    System.out.println(solution(s));
  }

  public static String solution(String s) {
    if (s.length() % 2 != 0)
      return s.charAt(s.length() / 2) + "";
    else {
      StringBuilder sb = new StringBuilder();
      sb.append(s.charAt(s.length()/2-1)).append(s.charAt(s.length()/2));
      return sb.toString();
    }
  }
}
