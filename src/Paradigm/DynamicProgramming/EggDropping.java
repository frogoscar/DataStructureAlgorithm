package Paradigm.DynamicProgramming;

// The following is a description of the instance of this famous puzzle
// involving n=2 eggs and a building with k=36 floors.
// Suppose that we wish to know which stories in a 36-story building
// are safe to drop eggs from, and which will cause the eggs to
// break on landing. We make a few assumptions:
//
// …..An egg that survives a fall can be used again.
// …..A broken egg must be discarded.
// …..The effect of a fall is the same for all eggs.
// …..If an egg breaks when dropped, then it would break if dropped
// from a higher floor.
// …..If an egg survives a fall then it would survive a shorter fall.
// …..It is not ruled out that the first-floor windows break eggs,
// nor is it ruled out that the 36th-floor do not cause an egg to break.
//
// If only one egg is available and we wish to be sure of obtaining
// the right result, the experiment can be carried out in only one
// way. Drop the egg from the first-floor window; if it survives,
// drop it from the second floor window. Continue upward until it breaks.
// In the worst case, this method may require 36 droppings. Suppose 2
// eggs are available. What is the least number of egg-droppings that
// is guaranteed to work in all cases?
// The problem is not actually to find the critical floor, but merely
// to decide floors from which eggs should be dropped so that total
// number of trials are minimized
//
public class EggDropping {
    // Function to get minimum number of trials needed in worst
    // case with n eggs and k floors
    static int eggDrop(int n, int k) {
        // If there are no floors, then no trials needed.
        // or If there is one floor, one trial needed
        if (k == 0 || k == 1) {
            return k;
        }
        // We need k trials for one egg and k floors
        if (n == 1) {
            return k;
        }
        int min = Integer.MAX_VALUE;
        // Consider all droppings from 1st floor to kth floor and
        // return the minimum of these values plus 1
        for (int i = 1; i <= k; i++) {
            min = Math.min(min,
                    Math.max(eggDrop(n - 1, i - 1), eggDrop(n, k - i)));
        }
        return min + 1;
    }

    // Not very efficient though
    // Time  : O(nk^2)
    // Space : O(nk)
    static int eggDropDP(int n, int k) {
        // A 2D table where entry dp[i][j] will represent minimum
        // number of trials needed for i eggs and j floors
        int[][] dp = new int[n + 1][k + 1];
        int i, j, x;

        // We need one trial for one floor and 0 trials for 0 floors
        for (i = 1; i <= n; i++) {
            dp[i][1] = 1;
            dp[i][0] = 0;
        }

        // We always need j trials for one egg and j floors
        for (j = 1; j <= k; j++) {
            dp[1][j] = j;
        }

        // Fill rest of the entries in table
        // using optimal substructure property
        for (i = 2; i <= n; i++) {
            for (j = 2; j <= k; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (x = 1; x <= j; x++) {
                    dp[i][j] = Math.min(dp[i][j],
                            1 + Math.max(dp[i - 1][x - 1], dp[i][j - x]));
                }
            }
        }

        return dp[n][k];
    }

    // Time  : O(nlogk)
    // Space : O(nk)
    static int eggDropDPSimple(int n, int k) {
        int[][] dp = new int[k + 1][n + 1];
        int f = 0;
        while (dp[f][n] < k) {
            f++;
            for (int i = 1; i <= n; i++) {
                dp[f][i] = dp[f - 1][i - 1] + dp[f - 1][i] + 1;
            }
        }
        return f;
    }

    // Do binary search to find minimum
    // number of trials in worst case
    // Time  : O(nlogk)
    // Space : O(1)
    static int eggDropUsingBinarySearch(int n, int k) {
        // Initialize low and high as 1st and last floors
        int low = 1, high = k;

        // Do binary search, for every mid,
        // find sum of binomial coefficients and
        // check if the sum is greater than k or not
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (binomialCoeff(mid, n, k) < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }

    // Find sum of binomial coefficients xCi
    // (where i varies from 1 to n). If the sum
    // becomes more than K
    static int binomialCoeff(int x, int n, int k) {
        int sum = 0, term = 1;
        for (int i = 1; i <= n && sum < k; ++i) {
            term *= x - i + 1;
            term /= i;
            sum += term;
        }
        return sum;
    }

    public static void main(String[] args) {
        int n = 2, k = 10;
        System.out.print("Minimum number of " + "trials in worst case with "
                + n + " eggs and " + k + " floors is " + eggDrop(n, k));
        System.out.print("\nMinimum number of " + "trials in worst case with "
                + n + " eggs and " + k + " floors is " + eggDropDP(n, k));
        System.out.print("\nMinimum number of " + "trials in worst case with "
                + n + " eggs and " + k + " floors is " + eggDropDPSimple(n, k));
        System.out.print("\nMinimum number of " + "trials in worst case with "
                + n + " eggs and " + k + " floors is " + eggDropUsingBinarySearch(n, k));
    }
}
