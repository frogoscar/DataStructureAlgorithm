package Paradigm.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Given a collection of numbers that might contain duplicates,
// return all possible unique permutations.
// Input: [1,1,2]
// Output:
// [
//  [1,1,2],
//  [1,2,1],
//  [2,1,1]
// ]
public class Permutations2 {
    static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(res, new ArrayList<>(), nums, new boolean[nums.length]);
        return res;
    }

    static void backtrack(List<List<Integer>> res, List<Integer> list, int[] nums, boolean[] used) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            used[i] = true;
            list.add(nums[i]);
            backtrack(res, list, nums, used);
            used[i] = false;
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        System.out.println(permute(nums));
    }
}
