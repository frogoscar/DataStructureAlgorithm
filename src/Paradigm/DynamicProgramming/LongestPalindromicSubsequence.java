package Paradigm.DynamicProgramming;

// If the given sequence is “BBABCBCAB”, then the output should be
// 7 as “BABCBAB” is the longest palindromic subsequence in it.
public class LongestPalindromicSubsequence {
    // Use recursive solution, not using DP
    // i is the first character, j is the last character
    static int lpsNaive(String s, int i, int j) {
        // Base Case 1: If there is only 1 character
        if (i == j) {
            return 1;
        }
        // Base Case 2: If there are only 2 characters and both are same
        if (i + 1 == j && s.charAt(i) == s.charAt(j)) {
            return 2;
        }
        // If the first and last characters match
        if (s.charAt(i) == s.charAt(j)) {
            return lpsNaive(s, i + 1, j - 1) + 2;
        }
        // If the first and last characters do not match
        return Math.max(lpsNaive(s, i, j - 1), lpsNaive(s, i + 1, j));
    }

    // Use DP adn Two Dimensional Array
    static int lpsDPTwoDimen(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        int i, ls, j;

        // Strings of length 1 are palindrome of length 1
        for (i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        // Build the table. Note that the lower
        // diagonal values of table are
        // useless and not filled in the process
        // ls means Length of Substring
        for (ls = 2; ls <= n; ls++) {
            for (i = 0; i < n - ls + 1; i++) {
                j = i + ls - 1;
                if (s.charAt(i) == s.charAt(j) && ls == 2) {
                    dp[i][j] = 2;
                } else if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[0][n - 1];
    }

    // Use DP adn One Dimensional Array
    static int lpsDPOneDimen(String s) {
        int n = s.length();

        // a[i] is going to store length
        // of longest palindromic subsequence
        // of substring s[0..i]
        int[] dp = new int[n];

        // Pick starting point
        for (int i = n - 1; i >= 0; i--) {
            int backup = 0;

            // Pick ending points and see if s[i]
            // increases length of longest common
            // subsequence ending with s[j].
            for (int j = i; j < n; j++) {
                if (i == j) {
                    // similar to 2D array L[i][j] == 1
                    // i.e., handling substrings of length one
                    dp[j] = 1;
                } else if (s.charAt(i) == s.charAt(j)) {
                    // Similar to 2D array L[i][j] = L[i+1][j-1]+2
                    // i.e., handling case when corner characters are same.
                    int temp = dp[j];
                    dp[j] = backup + 2;
                    backup = temp;
                } else {
                    backup = dp[j];
                    dp[j] = Math.max(dp[j - 1], dp[j]);
                }
            }
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {
        String seq = "GEEKSFORGEEKS";
        int n = seq.length();

        System.out.printf("The length of the LPS is %d", lpsNaive(seq, 0, n - 1));

        System.out.printf("\nThe length of the LPS is %d", lpsDPTwoDimen(seq));

        System.out.printf("\nThe length of the LPS is %d", lpsDPOneDimen(seq));
    }
}
