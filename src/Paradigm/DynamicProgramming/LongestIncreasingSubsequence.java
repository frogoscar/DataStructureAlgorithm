package Paradigm.DynamicProgramming;

import java.util.Arrays;

// LIS means Longest Increasing Subsequence
// The Longest Increasing Subsequence (LIS) problem is to find the length
// of the longest subsequence of a given sequence such that all elements
// of the subsequence are sorted in increasing order.
// For example, the length of LIS for {10, 22, 9, 33, 21, 50, 41, 60, 80}
// is 6 and LIS is {10, 22, 33, 50, 60, 80}
public class LongestIncreasingSubsequence {

    // Time  : O(n^2)
    // Space : O(n)
    static int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        // dp(i) is the length of the LIS ending at index i
        // such that arr[i] is the last element of the LIS
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {10, 22, 9, 33, 21, 50, 41, 60};
        System.out.println("Length of lis is "
                + lengthOfLIS(arr) + "\n");
    }
}
