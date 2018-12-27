package Paradigm.DynamicProgramming;

// Given two words word1 and word2, find the minimum number
// of operations required to convert word1 to word2.
//
// You have the following 3 operations permitted on a word:
//
// Insert a character
// Delete a character
// Replace a character
public class EditDistance {
    static int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                // If first string is empty, only option is to
                // insert all characters of second string
                if (i == 0) {
                    dp[i][j] = j;   // Min. operations = j
                }
                // If second string is empty, only option is to
                // remove all characters of second string
                else if (j == 0) {
                    dp[i][j] = i;   // Min. operations = i
                }
                // If last characters are same, ignore last char
                // and recur for remaining string
                else if (word1.charAt(i - 1)
                        == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                // If the last character is different, consider all
                // possibilities and find the minimum
                else {
                    dp[i][j] = 1 + Math.min(dp[i][j - 1],  // Insert
                            Math.min(dp[i - 1][j],  // Remove
                                    dp[i - 1][j - 1])); // Replace
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String args[]) {
        String word1 = "horse";
        String word2 = "ros";
        System.out.println("Edit distance of " + word1 + " and " + word2 +
                " is " + minDistance(word1,word2));
    }
}
