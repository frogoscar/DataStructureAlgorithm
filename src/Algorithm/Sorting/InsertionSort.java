package Algorithm.Sorting;

public class InsertionSort {

    // Best    : O(n)
    // Average : O(n^2)
    // Worst   : O(n^2)
    static void sort(int[] nums) {
        int N = nums.length;
        if (N <= 1) {
            return;
        }
        int value;
        int hole;
        for (int i = 1; i < N; i++) {
            value = nums[i];
            hole = i;
            while (hole > 0 && nums[hole - 1] > value) {
                nums[hole] = nums[hole - 1];
                hole--;
            }
            nums[hole] = value;
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
