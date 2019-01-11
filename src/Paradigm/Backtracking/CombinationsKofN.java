package Paradigm.Backtracking;

import java.util.ArrayList;
import java.util.List;

// Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
// Example :
// Input: n = 4, k = 2
// Output:
// [
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
// ]
public class CombinationsKofN {
    static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), 1, n, k);
        return res;
    }

    static void backtrack(List<List<Integer>> res, List<Integer> comb, int start, int n, int k) {
        if (k == 0) {
            res.add(new ArrayList<>(comb));
            return;
        }

        for (int i = start; i <= n; i++) {
            comb.add(i);
            backtrack(res, comb, i + 1, n, k - 1);
            comb.remove(comb.size() - 1);
        }
    }

    public static void main(String[] args) {
        int n = 5, k = 3;
        System.out.println(combine(n, k));
    }
}
