package Algorithm.SlidingWindow;

// Given an array of integers of size ‘n’.
// Our aim is to calculate the maximum sum of ‘k’
// consecutive elements in the array.
// Input  : arr[] = {100, 200, 300, 400}
//         k = 2
// Output : 700
//
// Input  : arr[] = {1, 4, 2, 10, 23, 3, 1, 0, 20}
//         k = 4
// Output : 39
// We get maximum sum by adding sub array {4, 2, 10, 23}
// of size 4.
//
// Input  : arr[] = {2, 3}
//         k = 3
// Output : Invalid
// There is no sub array of size 3 as size of whole
// array is 2.
public class MaxSum {
    // This uses nested for loop, not efficient
    // Time : O(k * n)
    static int maxSumNaive(int[] nums, int k) {
        if (nums.length < k) {
            System.out.println("Invalid");
            return -1;
        }
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < n - k; i++) {
            for (int j = 0; j < k; j++) {
                sum += nums[i + j];
            }
            max = Math.max(max, sum);
            sum = 0;
        }
        return max;
    }

    // Sliding Window Technique, more efficient
    // Time : O(n)
    static int maxSumUsingSlidingWindowTech(int[] nums, int k) {
        if (nums.length < k) {
            System.out.println("Invalid");
            return -1;
        }
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        int max = sum;
        for (int i = k; i < n; i++) {
            sum += nums[i] - nums[i - k];
            max = Math.max(max, sum);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {1, 4, 2, 10, 23, 3, 1, 0, 20};
        int k = 4;
        System.out.println("Naive solution : ");
        System.out.println("Max sum of " + k + " consecutive elements is " + maxSumNaive(nums, k));
        System.out.println("\nSliding Window solution : ");
        System.out.println("Max sum of " + k + " consecutive elements is " + maxSumUsingSlidingWindowTech(nums, k));
    }
}
