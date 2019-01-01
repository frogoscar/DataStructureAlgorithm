package Paradigm.Backtracking;

import java.util.ArrayList;
import java.util.List;

// Given a collection of distinct integers, return all possible permutations.
// Input: [1,2,3]
// Output:
// [
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
// ]
public class Permutations {
    static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), nums);
        return res;
    }

    static void backtrack(List<List<Integer>> res, List<Integer> list, int[] nums) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
        }
        for (int i : nums) {
            if (list.contains(i)) {
                continue;   // Element already exists, skip
            }
            list.add(i);
            backtrack(res, list, nums);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(permute(nums));
    }
}
