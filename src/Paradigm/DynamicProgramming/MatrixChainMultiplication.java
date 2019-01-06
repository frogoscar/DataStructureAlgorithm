package Paradigm.DynamicProgramming;

// Given a sequence of matrices, find the most efficient way to multiply
// these matrices together. The problem is not actually to perform the
// multiplications, but merely to decide in which order to perform the multiplications
// For example, suppose A is a 10 × 30 matrix, B is a 30 × 5 matrix, and C is a 5 × 60 matrix
// (AB)C = (10×30×5) + (10×5×60) = 1500 + 3000 = 4500 operations
// A(BC) = (30×5×60) + (10×30×60) = 9000 + 18000 = 27000 operations
// Clearly the first parenthesizing requires less number of operations
public class MatrixChainMultiplication {
    // Matrix Ai has dimension p[i-1] x p[i] for i = 1..n
    static int minOperationsNaive(int[] p, int i, int j) {
        if (i == j) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        // place parenthesis at different places between first
        // and last matrix, recursively calculate count of
        // multiplications for each parenthesis placement and
        // return the minimum count
        for (int k = i; k < j; k++) {
            int count = minOperationsNaive(p, i, k)
                    + minOperationsNaive(p, k + 1, j)
                    + p[i - 1] * p[k] * p[j];
            min = Math.min(min, count);
        }
        return min;
    }

    // Matrix Ai has dimension p[i-1] x p[i] for i = 1..n
    // Time  : O(n^3)
    // Space : O(n^2)
    static int minOperationsDP(int[] p) {
        // For simplicity of the program, one extra row and one
        // extra column are allocated in dp[][].
        // 0th row and 0th column of dp[][] are not used
        int n = p.length;
        int[][] dp = new int[n][n];

        int i, j, k, L, cost;
        // dp[i,j] = Minimum number of scalar multiplications needed
        // to compute the matrix A[i]A[i+1]...A[j] = A[i..j] where
        // dimension of A[i] is p[i-1] x p[i]

        // cost is zero when multiplying one matrix
        for (i = 1; i < n; i++) {
            dp[i][i] = 0;
        }

        // L is chain length
        for (L = 2; L < n; L++) {
            for (i = 1; i < n - L + 1; i++) {
                j = i + L - 1;
                if (j == n) {
                    continue;
                }
                dp[i][j] = Integer.MAX_VALUE;
                for (k = i; k < j; k++) {
                    // cost is cost/scalar multiplications
                    cost = dp[i][k] + dp[k + 1][j] + p[i - 1] * p[k] * p[j];
                    dp[i][j] = Math.min(cost, dp[i][j]);
                }
            }
        }

        return dp[1][n - 1];
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 3};
        System.out.println("Minimum number of multiplications is "+
                minOperationsNaive(arr, 1, arr.length - 1));
        System.out.println("Minimum number of multiplications is "+
                minOperationsDP(arr));
    }
}
