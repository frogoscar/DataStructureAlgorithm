package Algorithm.Sorting;

public class BubbleSort {

    // Best    : O(n)
    // Average : O(n^2)
    // Worst   : O(n^2)
    static void sort(int[] nums) {
        int N = nums.length;
        if (N <= 1) {
            return;
        }
        int temp;
        // Optimized version using a boolean swapped
        boolean swapped;
        for (int i = 0; i < N - 1; i++) {
            swapped = false;
            for (int j = 0; j < N - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
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
