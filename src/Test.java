import java.util.ArrayList;
import java.util.List;

class Test {
    static void permuteUtil(List<Integer> origin, List<Integer> chosen, List<List<Integer>> res) {
        if (origin.isEmpty()) {
            res.add(chosen);
            System.out.println(chosen);
            System.out.println(res);
            System.out.println();
        }
        for (int i = 0; i < origin.size(); i++) {
            // Choose
            Integer num = origin.get(i);
            chosen.add(num);
            origin.remove(num);

            // Explore
            permuteUtil(origin, chosen, res);

            // Un-choose
            chosen.remove(chosen.size() - 1);
            origin.add(i, num);
        }
    }

    static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) {
            return res;
        }
        List<Integer> origin = new ArrayList<>();
        for (int i : nums) {
            origin.add(i);
        }
        permuteUtil(origin, new ArrayList<Integer>(), res);
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        //System.out.println(permute(nums));
        permute(nums);
    }
}