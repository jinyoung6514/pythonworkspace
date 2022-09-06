package programmers;

import java.util.Arrays;
import java.util.Comparator;

public class 문자열_내_마음대로_정렬하기 {
  public static void main(String[] args) {
    //Test1 : ["car", "bed", "sun"]
    // String[] strings = {"sun", "bed", "car"};
    // int n = 1;
    // Test2 : ["abcd", "abce", "cdx"]
    // String[] strings = {"abce", "abcd", "cdx"};
    // int n = 2;
    //Test3 : ["abzaa", "abzbb", "abzcd", "abzfg", "bbzaa", "cdzab"]
    // String[] strings = {"abzcd","cdzab","abzfg","abzaa","abzbb","bbzaa"};
    // int n = 2;
    //Test3 : ['ba', 'aea', 'aee', 'ce']
    String[] strings = {"aea", "ba", "ce", "aee"};
    int n = 1;

    System.out.println(Arrays.toString(solution(strings, n)));
  }

  public static String[] solution(String[] strings, int n) {
    Comparator<String> rule = new Comparator<String>() {

      @Override
      public int compare(String o1, String o2) {
        return o1.charAt(n)-o2.charAt(n);
      }
    };

    Arrays.sort(strings);
    Arrays.sort(strings,rule);
    
    return strings;
  }
}
