package Paradigm.DynamicProgramming;

// A binomial coefficient C(n, k) can be defined as the coefficient
// of X^k in the expansion of (1 + X)^n.
// A binomial coefficient C(n, k) also gives the number of ways,
// disregarding order, that k objects can be chosen from among n
// objects; more formally, the number of k-element subsets
// (or k-combinations) of an n-element set

// Write a function that takes two parameters n and k and
// returns the value of Binomial Coefficient C(n, k).
// For example, your function should return 6 for n = 4 and k = 2,
// and it should return 10 for n = 5 and k = 2
public class BinomialCoefficient {
    // The value of C(n, k) can be recursively calculated using
    // following standard formula for Binomial Coefficients
    // C(n, k) = C(n-1, k-1) + C(n-1, k)
    // C(n, 0) = C(n, n) = 1
    static int binomialCoeffNaive(int n, int k) {
        // Base Cases
        if (k == 0 || k == n) {
            return 1;
        }
        return binomialCoeffNaive(n - 1, k - 1)
                + binomialCoeffNaive(n - 1, k);
    }

    // Two dimensional array
    // Time  : O(n*k)
    // Space : O(n*k)
    static int binomialCoeffDP(int n, int k) {
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= Math.min(i, k); j++) {
                if (j == 0 || j == i) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }
            }
        }
        return dp[n][k];
    }

    // One dimensional array
    // Time  : O(n*k)
    // Space : O(k)
    // How does it work ? See below :
    // Let's say we want to calculate C(4, 3),
    // i.e. n=4, k=3:
    //
    // All elements of array C of size 4 (k+1) are
    // initialized to ZERO.
    //
    // i.e. C[0] = C[1] = C[2] = C[3] = C[4] = 0;
    // Then C[0] is set to 1 (because the whole column of k = 0 is 1, 1, 1...)
    //
    // For i = 1:
    // C[1] = C[1] + C[0] = 0 + 1 = 1 ==>> C(1,1) = 1
    //
    // For i = 2:
    // C[2] = C[2] + C[1] = 0 + 1 = 1 ==>> C(2,2) = 1
    // C[1] = C[1] + C[0] = 1 + 1 = 2 ==>> C(2,2) = 2
    //
    // For i = 3:
    // C[3] = C[3] + C[2] = 0 + 1 = 1 ==>> C(3,3) = 1
    // C[2] = C[2] + C[1] = 1 + 2 = 3 ==>> C(3,2) = 3
    // C[1] = C[1] + C[0] = 2 + 1 = 3 ==>> C(3,1) = 3
    //
    // For i = 4:
    // C[4] = C[4] + C[3] = 0 + 1 = 1 ==>> C(4,4) = 1
    // C[3] = C[3] + C[2] = 1 + 3 = 4 ==>> C(4,3) = 4
    // C[2] = C[2] + C[1] = 3 + 3 = 6 ==>> C(4,2) = 6
    // C[1] = C[1] + C[0] = 3 + 1 = 4 ==>> C(4,1) = 4
    //
    // C(4,3) = 4 would be the answer in our example.
    static int binomialCoeffDPSimple(int n, int k) {
        int[] dp = new int[k + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            // Compute next row of pascal
            // triangle using the previous row
            for (int j = Math.min(i, k); j > 0; j--) {
                dp[j] = dp[j] + dp[j - 1];
            }
        }
        return dp[k];
    }


    public static void main(String[] args) {
        int n = 5, k = 2;
        System.out.printf("Value of C(%d, %d) is %d ",
                n, k, binomialCoeffNaive(n, k));
        System.out.printf("\nValue of C(%d, %d) is %d ",
                n, k, binomialCoeffDP(n, k));
        System.out.printf("\nValue of C(%d, %d) is %d ",
                n, k, binomialCoeffDPSimple(n, k));
    }
}
