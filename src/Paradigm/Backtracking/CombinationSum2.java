package Paradigm.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
//
// Each number in candidates may only be used once in the combination.
// Input: candidates = [10,1,2,7,6,1,5], target = 8,
// A solution set is:
// [
//  [1, 7],
//  [1, 2, 5],
//  [2, 6],
//  [1, 1, 6]
// ]
public class CombinationSum2 {
    static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(res, new ArrayList<>(), candidates, target, 0);
        return res;
    }

    static void backtrack(List<List<Integer>> res, List<Integer> list, int[] nums, int remaining, int start) {
        if (remaining == 0) {
            res.add(new ArrayList<>(list));
        } else if (remaining > 0) {
            for (int i = start; i < nums.length; i++) {
                if (i > start && nums[i] == nums[i - 1]) {
                    continue;  // skip duplicates
                }
                list.add(nums[i]);
                backtrack(res, list, nums, remaining - nums[i], i + 1);
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {10,1,2,7,6,1,5};
        int target = 8;
        System.out.println(combinationSum2(nums, target));
    }
}
