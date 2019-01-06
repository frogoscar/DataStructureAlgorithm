package Algorithm.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

// Given a string S and a string T, find the minimum window in S
// which will contain all the characters in T in complexity O(n)
// Input: S = "ADOBECODEBANC", T = "ABC"
// Output: "BANC"
// If there is no such window in S that covers all characters in T, return the empty string ""
// If there is such window, you are guaranteed that there will always be only one
// unique minimum window in S
public class MinimumWindowSubstring {
    static String minWindow(String s, String t) {
        if (s.isEmpty() || t.isEmpty() || s.length() < t.length()) {
            return "";
        }
        // Initialize frequency table for t
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        // Initialize sliding window
        int counter = map.size();
        int begin = 0, end = 0, len = Integer.MAX_VALUE;
        String res = "";

        // Start sliding window
        while (end < s.length()) {
            char endChar = s.charAt(end);

            // If current char found in table, decrement count
            if (map.containsKey(endChar)) {
                map.put(endChar, map.get(endChar) - 1);
                if (map.get(endChar) == 0) {
                    counter--;
                }
            }

            end++;

            // If counter == 0, means we found an answer, now try to
            // trim that window by sliding begin to right
            while (counter == 0) {
                // Store new answer if smaller than previously best
                if (end - begin < len) {
                    len = end - begin;
                    res = s.substring(begin, end);
                }
                // Begin char could be in map or not,
                // If not, then good for us, it was a wasteful char and we
                // shorten the previously found substring.
                // If found in map, increment count in map, as we are leaving
                // it out of window and moving ahead,
                // so it would no longer be a part of the substring marked
                // by begin-end window.
                // Our map only has count of chars required to make the present
                // substring a valid candidate
                // If the count goes above zero means that the current window
                // is missing one char to be an answer candidate
                char beginChar = s.charAt(begin);
                if (map.containsKey(beginChar)) {
                    map.put(beginChar, map.get(beginChar) + 1);
                    if (map.get(beginChar) > 0) {
                        counter++;
                    }
                }
                begin++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println("Min Window Substring in " + s
                + " containing all chars in " + t + " is " + minWindow(s, t));
    }
}
