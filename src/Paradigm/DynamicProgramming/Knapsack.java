package Paradigm.DynamicProgramming;

// 0 - 1 Knapsack
// Given weights and values of n items, put these items in a knapsack of capacity
// W to get the maximum total value in the knapsack. In other words, given two integer
// arrays val[0..n-1] and wt[0..n-1] which represent values and weights associated
// with n items respectively.
// You cannot break an item, either pick the complete item, or don’t pick it (0-1 property)
public class Knapsack {
    // Recursive solution, not efficient
    // Time : O(2^n) where n is the number of items
    static int knapsackNaive(int W, int[] wt, int[] val, int n) {
        // Base case
        if (W == 0 || n == 0) {
            return 0;
        }
        // If weight of the nth item is more than Knapsack capacity W, then
        // this item cannot be included in the optimal solution
        if (wt[n - 1] > W) {
            return knapsackNaive(W, wt, val, n - 1);
        } else {
            // Return the maximum of two cases:
            // (1) nth item included
            // (2) not included
            return Math.max(val[n - 1] + knapsackNaive(W - wt[n - 1], wt, val, n - 1),
                    knapsackNaive(W, wt, val, n - 1));
        }
    }

    // Using Dynamic Programming (Bottom Up)
    // Time  : O(n * W)
    // Space : O(n * W)
    static int knapsackDP(int W, int[] wt, int[] val, int n) {
        int[][] dp = new int[n + 1][W + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= W; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (wt[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - wt[i - 1]] + val[i - 1]);
                }
            }
        }

        return dp[n][W];
    }

    // Time  : O(n * W)
    // Space : O(W)
    static int knapsackDPSimple(int W, int[] wt, int[] val, int n) {
        int[] dp = new int[W + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = W; j >= 0; j--) {
                dp[j] = wt[i - 1] > j ? dp[j] : Math.max(dp[j], dp[j - wt[i - 1]] + val[i - 1]);
            }
        }
        return dp[W];
    }

    public static void main(String[] args) {
        int[] wt = {10, 20, 30};
        int[] val = {60, 100, 200};
        int W = 50;
        int n = wt.length;

        System.out.println("The max value with naive solution is : "
                + knapsackNaive(W, wt, val, n));
        System.out.println("The max value with DP solution is : "
                + knapsackDP(W, wt, val, n));
        System.out.println("The max value with simple DP solution is : "
                + knapsackDPSimple(W, wt, val, n));
    }
}
