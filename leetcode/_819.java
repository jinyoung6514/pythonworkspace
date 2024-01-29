package leetcode;

import java.util.*;

/**
 * 가장 흔한 단어
 *
 * 금지된 단어를 제외하고 가장 흔하게 등장하는 단어를 출력하라. 대소문자를 구분하지 않으며, 구두점(마침표, 쉼표) 또한 무시한다.
 *
 * input: "Bob hit a ball, the hit BALL flew far after it was hit."
 * banned: ["hit"]
 * output: "ball"
 */
public class _819 {

    public static void main(String[] args) {
        System.out.println(mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", new String[]{"hit"}));
    }

    public static String mostCommonWord(String paragraph, String[] banned) {

        Set<String> ban = new HashSet(Arrays.asList(banned));

        String[] words = paragraph.replaceAll("\\W+", " ").toLowerCase().split(" ");

        Map<String, Integer> map = new HashMap<>();

        for (String word : words) {
            if (!ban.contains(word)) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }

        return Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
}
