package Paradigm.Backtracking;

import java.util.*;

// Input  : str = “()())()” -
// Output : ()()() (())()
// There are two possible solutions
// "()()()" and "(())()"
//
// Input  : str = (v)())()
// Output : (v)()()  (v())()
public class RemoveInvalidParentheses {
    // Checks if character is parenthesis(open or closed)
    static boolean isParenthesis(char c) {
        return c == '(' || c == ')';
    }

    // Returns true if string contains valid parenthesis
    static boolean isValid(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                count++;
            } else if (c == ')') {
                count--;
            }
            if (count < 0) {
                return false;
            }
        }
        return count == 0;
    }

    // Method to remove invalid parenthesis
    // Return all valid results.
    // Use BFS with Queue
    static List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        if (s.isEmpty()) {
            return res;
        }
        // Set to ignore already visited string
        HashSet<String> visited = new HashSet<>();
        // Queue to maintain BFS
        Queue<String> queue = new LinkedList<>();
        String tmp;
        boolean level = false;

        // Push given string as starting node into queue
        queue.add(s);
        visited.add(s);

        while (!queue.isEmpty()) {
            s = queue.poll();
            if (isValid(s)) {
                res.add(s);
                // If answer is found, make level true
                // so that valid string of only that level
                // are processed
                level = true;
            }
            if (level) {
                continue;
            }
            for (int i = 0; i < s.length(); i++) {
                if (!isParenthesis(s.charAt(i))) {
                    continue;
                }
                // Removing parenthesis from str and
                // pushing into queue, if not visited already
                tmp = s.substring(0, i) + s.substring(i + 1);
                if (!visited.contains(tmp)) {
                    queue.add(tmp);
                    visited.add(tmp);
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        String expression = "()())()";
        System.out.println("All valid results after removing invalid" +
                " parentheses in " + expression + " is :\n"
                + removeInvalidParentheses(expression));

        expression = "(a)())()";
        System.out.println("\nAll valid results after removing invalid" +
                " parentheses in " + expression + " is :\n"
                + removeInvalidParentheses(expression));

        expression = ")(";
        System.out.println("\nAll valid results after removing invalid" +
                " parentheses in " + expression + " is :\n"
                + removeInvalidParentheses(expression));
    }
}
