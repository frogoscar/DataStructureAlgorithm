package Algorithm.SlidingWindow;

import java.util.Arrays;

// Given a word and a text, return the count of the occurrences
// of anagrams of the word in the text
// Input  : forxxorfxdofr
//          for
// Output : 3
// Explanation : Anagrams of the word for - for, orf,
// ofr appear in the text and hence the count is 3.
//
// Input :  aabaabaa
//          aaba
// Output : 4
// Explanation : Anagrams of the word aaba - aaba,
// abaa each appear twice in the text and hence the
// count is 4
public class CountAnagram {
    // Naive solution, not efficient
    static int countAnagramNaive(String text, String word) {
        if (text.length() < word.length()) {
            System.out.println("Invalid");
            return -1;
        }
        int t = text.length();
        int w = word.length();
        int count = 0;

        for (int i = 0; i <= t - w; i++) {
            if (isAnagram(word, text.substring(i, i + w))) {
                count++;
            }
        }

        return count;
    }

    static boolean isAnagram(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }

        char[] ch1 = a.toCharArray();
        char[] ch2 = b.toCharArray();

        Arrays.sort(ch1);
        Arrays.sort(ch2);

        return Arrays.equals(ch1, ch2);
    }

    ////////////////////////////////////////////////

    // Function to find if two strings are equal
    static boolean isCountZero(int[] count) {
        for (int i : count) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

    // Sliding Window Tech, more efficient
    static int countAnagramUsingSlidingWindow(String text, String word) {
        if (text.length() < word.length()) {
            System.out.println("Invalid");
            return -1;
        }
        int t = text.length();
        int w = word.length();

        int res = 0;

        // Check for first window. The idea is to
        // use single count array to match counts
        int[] count = new int[256];
        for (int i = 0; i < w; i++) {
            count[word.charAt(i)]++;
            count[text.charAt(i)]--;
        }
        if (isCountZero(count)) {
            res++;
        }

        for (int i = w; i < t; i++) {
            // Add last character of current window
            count[text.charAt(i)]--;
            // Remove first character of previous window
            count[text.charAt(i - w)]++;
            if (isCountZero(count)) {
                res++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        String s = "forxxorfxdofr";
        String t = "for";

        System.out.println("Naive solution : ");
        System.out.println("Count of anagrams of " + t + " in " + s
                + " is " + countAnagramNaive(s, t));
        System.out.println("\nSliding Window solution : ");
        System.out.println("Count of anagrams of " + t + " in " + s
                + " is " + countAnagramUsingSlidingWindow(s, t));
    }
}
