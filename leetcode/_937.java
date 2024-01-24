package leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 로그 파일 재정렬
 *
 * input : ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
 * output : ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]
 *
 * 규칙
 * 1. 로그의 가장 앞부분은 식별자로서, 순서에 영향을 끼치지 않는다.
 * 2. 문자로 구성된 로그가 숫자 로그보다 앞에 오며, 문자 로그는 사전순으로 한다.
 * 3. 문자가 동일할 경우에는 식별자순으로 한다.
 * 4. 숫자 로그는 입력 순서대로 한다.
 */
public class _937 {
    /**
     * 문자 로그와 숫자 로그를 구분해 각각 처리
     */
    class Solution{
        public String[] reorderLogFiles(String[] logs) {
            List<String> letter = new ArrayList<>();
            List<String> digit = new ArrayList<>();

            for (String log : logs) {
                if (Character.isDigit(log.split(" ")[1].charAt(0))) {
                    digit.add(log);
                } else {
                    letter.add(log);
                }
            }

            letter.sort((s1, s2) -> {
                //식별자와 식별자 외 나머지 부분으로 나누기
                String[] s1x = s1.split(" ", 2);
                String[] s2x = s2.split(" ", 2);

                //사전 순 비교(s1x가 더 작으면 -1, 같으면 0, 더 크면 1)
                int compared = s1x[1].compareTo(s2x[1]);

                //같을 경우 식별자 비교
                if (compared == 0) {
                    return s1x[0].compareTo(s2x[0]);
                } else {
                    return compared;
                }
            });

            letter.addAll(digit);

            return letter.toArray(new String[0]);
        }
    }
}
