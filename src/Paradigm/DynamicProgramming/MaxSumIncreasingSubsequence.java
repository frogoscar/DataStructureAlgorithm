package Paradigm.DynamicProgramming;

// Given an array of n positive integers. Write a program to find the sum of
// maximum sum subsequence of the given array such that the integers in the
// subsequence are sorted in increasing order. For example, if input is
// {1, 101, 2, 3, 100, 4, 5}, then output should be 106 (1 + 2 + 3 + 100),
// if the input array is {3, 4, 5, 10}, then output should be 22 (3 + 4 + 5 + 10)
// and if the input array is {10, 5, 4, 3}, then output should be 10
// Note :
// This problem is a variation of standard Longest Increasing Subsequence (LIS) problem.
// We need a slight change in the Dynamic Programming solution of LIS problem.
// All we need to change is to use sum as a criteria instead of length of increasing subsequence
public class MaxSumIncreasingSubsequence {
    // Time  : O(n^2)
    // Space : O(n)
    static int maxSumIS(int[] nums) {
        int i, j, max = Integer.MIN_VALUE;
        int n = nums.length;
        int[] dp = new int[n];

        // Initialize dp values for all indexes
        for (i = 0; i < n; i++) {
            dp[i] = nums[i];
        }

        for (i = 1; i < n; i++) {
            for (j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {  // Make sure it is Increasing
                    dp[i] = Math.max(dp[i], dp[j] + nums[i]);
                }
            }
            max = Math.max(dp[i], max);
        }

        return max;
    }

    public static void main(String[] args) {
        int[] nums = {1, 101, 2, 3, 100, 4, 5};
        System.out.println("Sum of maximum sum "+ "increasing subsequence is "+ maxSumIS(nums));
    }
}
