package Paradigm.DynamicProgramming;

// Longest Common Subsequence
public class LCS {
    static int lcsLength(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        int dp[][] = new int[n1 + 1][n2 + 1];
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n1][n2];
    }

    public static void main(String[] args) {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";

        System.out.println("Length of Longest Common Subsequence is " +
                lcsLength(s1, s2));
    }
}
