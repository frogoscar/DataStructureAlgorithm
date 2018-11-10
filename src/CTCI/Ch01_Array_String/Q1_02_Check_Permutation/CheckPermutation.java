package CTCI.Ch01_Array_String.Q1_02_Check_Permutation;

public class CheckPermutation {
    /**
     * Question :
     * Given two strings, write a method to decide if one is a permutation of the other.
     *
     * Answer : You should understand if the permutation comparison is case sensitive.
     * You should also ask if whitespace is significant.
     * For this problem we will assume that the comparison is case sensitive and
     * whitespace is significant. Strings of different lengths cannot be permutations
     * of each other.
     */

    /**
     * Solution 1 : Sort the strings. O(nlogn)
     *
     * @param s
     * @param t
     * @return String s is permutation of String t or not
     */
    static boolean permutation_1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        return sort(s).equals(sort(t));
    }
    static String sort(String s) {
        char[] content = s.toCharArray();
        java.util.Arrays.sort(content);
        return new String(content);
    }

    /**
     * Solution 2 : Check if the two strings have identical character counts. O(n)
     *
     * @param s
     * @param t
     * @return String s is permutation of String t or not
     */
    static boolean permutation_2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] letters = new int[128];  // Assumption

        // Count number of each character in s
        for (char c : s.toCharArray()) {
            letters[c]++;
        }

        for (char c : t.toCharArray()) {
            letters[c]--;
            if (letters[c] < 0) {
                return false;
            }
        }

        return true;
    }
}
