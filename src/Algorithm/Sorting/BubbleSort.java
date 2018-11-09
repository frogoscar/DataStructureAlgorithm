package Algorithm.Sorting;

public class BubbleSort {

    // Time complexity : O(n^2)
    static void sort(int[] nums) {
        int N = nums.length;
        int temp;
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < N - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }

    static void printArray(int[] nums) {
        for (int i : nums) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 5, 12, 23, 9};
        System.out.println("Before sorting : ");
        printArray(nums);
        sort(nums);
        System.out.println("After sorting : ");
        printArray(nums);
    }
}
