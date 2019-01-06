package Paradigm.DynamicProgramming;

// If the given string is “forgeeksskeegfor”,
// the output should be “geeksskeeg”
public class LongestPalindromicSubstring {
    static String lps(String s) {
        if (s.length() == 0) {
            return "";
        }

        int n = s.length();
        // table[i][j] will be false if substring str[i..j]
        // is not palindrome. Else, table[i][j] will be true
        boolean[][] dp = new boolean[n][n];

        int maxLength = 1;

        // All substrings of length 1 are palindromes
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        int start = 0;
        int i, ls, j;

        // check for sub-string of length 2
        for (i = 0; i < n - 1; ++i) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                start = i;
                maxLength = 2;
            }
        }

        // ls is length of substring
        for (ls = 3; ls <= n; ls++) {
            // i is the starting index
            for (i = 0; i < n - ls + 1; i++) {
                // j is ending index of substring from starting index i and length ls
                j = i + ls - 1;
                // checking for sub-string from ith index to
                // jth index iff str.charAt(i+1) to
                // str.charAt(j-1) is a palindrome
                if (dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = true;
                    if (ls > maxLength) {
                        start = i;
                        maxLength = ls;
                    }
                }
            }
        }

        return s.substring(start, start + maxLength);
    }

    public static void main(String[] args) {
        String str = "forgeeksskeegfor";
        System.out.println("Longest Palindromic Substring is: " + lps(str));
    }
}
