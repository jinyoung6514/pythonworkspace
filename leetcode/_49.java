package leetcode;

import java.util.*;

/**
 * 그룹 애너그램
 *
 * 문자열 배열을 받아 애너그램 단위로 그룹핑하라.
 *
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 */
public class _49 {

    public static void main(String[] args) {

    }

    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {

            Map<String, List<String>> map = new HashMap<>();

            for (String str : strs) {
                char[] chars = str.toCharArray();
                Arrays.sort(chars);

                String key = String.valueOf(chars);

                //기존에 없던 키라면 빈 리스트를 삽입
                if (!map.containsKey(key)) {
                    map.put(key, new ArrayList<>());
                }
                map.get(key).add(str);
            }
            return new ArrayList<>(map.values());
        }
    }
}
