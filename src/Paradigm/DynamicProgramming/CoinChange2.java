package Paradigm.DynamicProgramming;

// You are given coins of different denominations and a total amount of
// money. Write a function to compute the number of combinations that
// make up that amount. You may assume that you have infinite number of each kind of coin
// Input: amount = 5, coins = [1, 2, 5]
// Output: 4
// Explanation: there are four ways to make up the amount:
// 5=5
// 5=2+2+1
// 5=2+1+1+1
// 5=1+1+1+1+1
//
// Input: coins = [2], amount = 3
// Output: -1
public class CoinChange2 {
    // Returns the count of ways we can
    // sum coins[0...m-1] coins to get sum amount
    static int changeNaive(int amount, int[] coins, int m) {
        // If amount is 0 then there is 1 solution (do not include any coin)
        if (amount == 0) {
            return 1;
        }
        // If amount is less than 0 then no solution exists
        if (amount < 0) {
            return 0;
        }
        // If there are no coins and n
        // is greater than 0, then no solution exist
        if (m <= 0) {
            return 0;
        }
        // count is sum of solutions
        // (i)  including S[m - 1]
        // (ii) excluding S[m - 1]
        return changeNaive(amount - coins[m - 1], coins, m)
                + changeNaive(amount, coins, m - 1);
    }

    // To count the total number of solutions,
    // we can divide all set solutions into two sets.
    // 1) Solutions that do not contain mth coin (or Sm).
    // 2) Solutions that contain at least one Sm.
    // Let count(S[], m, n) be the function to count the number of solutions,
    // then it can be written as sum of count(S[], m-1, n) and count(S[], m, n-Sm)
    // Time  : O(amount * coins.length)
    // Space : O(amount)
    static int change(int amount, int[] coins) {
        // dp[i] will be storing the number of solutions
        // for value i. We need n+1 rows as the table is
        // constructed in bottom up manner using the base
        // case (n = 0)
        int[] dp = new int[amount + 1];

        // Base case (If given value is 0)
        // There is 1 solution (do not include any coin)
        dp[0] = 1;

        // Pick all coins one by one and update the table[]
        // values after the index greater than or equal to
        // the value of the picked coin
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }

        return dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 5;
        int m = coins.length;
        System.out.println("Number of combinations is " + changeNaive(amount, coins, m));
        System.out.println("Number of combinations is " + change(amount, coins));
    }
}
