package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 두 수의 합
 *
 * 덧셈하여 타깃을 만들 수 있는 배열의 두 숫자 인덱스를 리턴하라
 *
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 */
public class _1 {

    static class Solution {

        /**
         * 첫 번째 수를 뺀 결과 키 조회 방식 O(n)
         */
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> numsMap = new HashMap<>();

            for (int i = 0; i < nums.length; i++) {
                if (numsMap.containsKey(target - nums[i])) {
                    return new int[]{numsMap.get(target - nums[i]), i};
                }

                numsMap.put(nums[i], i);
            }
            return null;
        }

        /**
         * 브루트포스 방식을 이용한 문제풀이 O(n2)
         */
        public int[] twoSumBruteForce(int[] nums, int target) {
            for (int i = 0; i < nums.length-1; i++) {
                for (int j = i+1; j < nums.length; j++) {
                    if (nums[i] + nums[j] == target) {
                        return new int[]{i, j};
                    }
                }
            }
            return null;
        }
    }
}
