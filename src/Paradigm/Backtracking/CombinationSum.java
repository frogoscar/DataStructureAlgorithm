package Paradigm.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Given a set of candidate numbers (candidates) (without duplicates)
// and a target number (target), find all unique combinations in candidates
// where the candidate numbers sums to target.
//
// The same repeated number may be chosen from candidates unlimited number of times.
//
// All numbers (including target) will be positive integers.
// The solution set must not contain duplicate combinations.
// Input: candidates = [2,3,6,7], target = 7,
// A solution set is:
// [
//  [7],
//  [2,2,3]
// ]
public class CombinationSum {
    static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(res, new ArrayList<>(), candidates, target, 0);
        return res;
    }

    static void backtrack(List<List<Integer>> res, List<Integer> list, int[] nums,
                          int remaining, int start) {
        if (remaining == 0) {
            res.add(new ArrayList<>(list));
        } else if (remaining > 0) {
            for (int i = start; i < nums.length; i++) {
                list.add(nums[i]);
                backtrack(res, list, nums, remaining - nums[i], i); // Not i + 1 because allowing duplicates
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {2,3,6,7};
        int target = 7;
        System.out.println(combinationSum(nums, target));
    }
}
