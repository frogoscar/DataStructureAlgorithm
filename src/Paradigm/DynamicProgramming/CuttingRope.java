package Paradigm.DynamicProgramming;

// Given a rope of length n meters, cut the rope in different parts
// of integer lengths in a way that maximizes product of lengths of
// all parts. You must make at least one cut. Assume that the length
// of rope is more than 2 meters
// Input: n = 2
// Output: 1 (Maximum obtainable product is 1*1)
//
// Input: n = 3
// Output: 2 (Maximum obtainable product is 1*2)
//
// Input: n = 4
// Output: 4 (Maximum obtainable product is 2*2)
//
// Input: n = 5
// Output: 6 (Maximum obtainable product is 2*3)
//
// Input: n = 10
// Output: 36 (Maximum obtainable product is 3*3*4)
public class CuttingRope {
    // maximum product obtainable from a rope of length n
    static int maxProd(int n) {
        // Base case
        if (n == 0 || n == 1) {
            return 0;
        }
        // Make a cut at different places and take the maximum of all
        int max = 0;
        for (int i = 1; i < n; i++) {
            max = Math.max(max, Math.max(i * (n - i), maxProd(n - i) * i));
        }
        return max;
    }

    // Time  : O(n^2)
    // Space : O(n)
    static int maxProdDP(int n) {
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 0;
        for (int i = 1; i <= n; i++) {
            int max = 0;
            for (int j = 1; j <= i / 2; j++) {
                max = Math.max(max, Math.max((i - j) * j, dp[i - j] * j));
            }
            dp[i] = max;
        }
        return dp[n];
    }

    // Time  : O(n)
    // Space : O(1)
    //
    // Logic :
    // When n >= 5, we cut the rope with each time a size
    // of 3, because :
    // 3(n - 3) > n and 2(n - 2) > n   (when n >= 5)
    // and also 3(n - 3) >= 2(n - 2)   (when n >= 5)
    // When the size left is 4, then the max is 2 * 2 = 4 itself
    static int maxProdGreedy(int n) {
        // n equals to 2 or 3 must be handled explicitly
        if (n == 2 || n == 3) {
            return n - 1;
        }
        int res = 1;
        // Keep removing parts of size 3 while n is greater than 4
        while (n > 4) {
            n -= 3;
            res *= 3;
        }
        // The last part multiplied by previous parts
        return res * n;
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println("Maximum Product is " + maxProd(n));
        System.out.println("Maximum Product is " + maxProdDP(n));
        System.out.println("Maximum Product is " + maxProdGreedy(n));
    }
}
