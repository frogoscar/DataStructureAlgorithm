package LeetCode.Hard;

import java.util.Arrays;

public class Q41_FirstMissingPositive {
    /**
     * Question :
     * Given an unsorted integer array, find the smallest missing positive integer.
     * @param nums
     * @return Smallest missing positive integer
     */
    static int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int min = 1;
        for (int i : nums) {
            if (i == min) {
                min++;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[] A1 = {1, 2, 1, 3, 4, 5, 6};
        int[] A2 = {-1, -2, -3, -4};

        System.out.println(firstMissingPositive(A1));
        System.out.println(firstMissingPositive(A2));
    }
}
