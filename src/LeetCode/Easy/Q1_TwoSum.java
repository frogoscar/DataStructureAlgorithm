package LeetCode.Easy;

import java.util.HashMap;
import java.util.Map;

public class Q1_TwoSum {
    /**
     * Question :
     * Given an array of integers, return indices of the two numbers such
     * that they add up to a specific target.
     * You may assume that each input would have exactly one solution,
     * and you may not use the same element twice.
     *
     * Example :
     * Given nums = [2, 7, 11, 15], target = 9,
     * Because nums[0] + nums[1] = 2 + 7 = 9,
     * return [0, 1].
     *
     * @param nums
     * @param target
     * @return Int Array of the two index
     */
    static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] {map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;

        int[] solution = twoSum(nums, target);

        System.out.print("[");
        System.out.print(solution[0] + ",");
        System.out.print(solution[1]);
        System.out.print("]");
        System.out.println();
    }
}
