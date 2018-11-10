package LeetCode.Easy;

import java.util.Arrays;

public class Q268_MissingNumber {
    /**
     * Question :
     * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n,
     * find the one that is missing from the array.
     *
     * @param nums
     * @return Missing number
     */
    static int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int missing = 0;
        for (int i : nums) {
            if (i == missing) {
                missing++;
            }
        }
        return missing;
    }

    public static void main(String[] args) {
        int[] nums = {3, 0, 1};
        System.out.println(missingNumber(nums));
    }
}
