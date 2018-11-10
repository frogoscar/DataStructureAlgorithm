package CTCI.Ch01_Array_String.Q1_01_Is_Unique;

public class IsUnique {
    /**
     * Question :
     * Implement an algorithm to determine if a string has all unique characters.
     * What if you can not use additional data structures ?
     *
     * Answer :
     * You should first ask your interviewer if the string is an ASCII string
     * or Unicode string. We will assume for simplicity the character set is ASCII.
     */

    /**
     * Solution 1 :
     * The following solution has time complexity O(n) and space complexity O(1) :
     *
     * @param str
     * @return If String str has all unique characters
     */
    static boolean isUniqueChars_1(String str) {
        if (str.length() > 128) {
            return false;
        }
        boolean[] charSet = new boolean[128];
        for (int i = 0; i < str.length(); i++) {
            char val = str.charAt(i);
            if (charSet[val]) {
                return false;
            }
            charSet[val] = true;
        }
        return true;
    }

    /**
     * Solution 2 :
     * If we can not use additional data structures, we can do the following in O(n^2) :
     *
     * @param str
     * @return If String str has all unique characters
     */
    static boolean isUniqueChars_2(String str) {
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] words = {"abcde", "hello", "apple", "kite", "padle"};
        for (String word : words) {
            System.out.println(word + " : " + isUniqueChars_1(word));
        }
    }
}
