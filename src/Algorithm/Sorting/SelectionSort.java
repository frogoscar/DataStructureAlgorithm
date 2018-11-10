package Algorithm.Sorting;

public class SelectionSort {

    // Best    : O(n^2)
    // Average : O(n^2)
    // Worst   : O(n^2)
    static void sort(int[] nums) {
        int N = nums.length;
        if (N <= 1) {
            return;
        }
        // One by one move boundary of unsorted sub array
        for (int i = 0; i < N - 1; i++) {
            // Find the minimum element in unsorted array
            int minIdx = i;
            for (int j = i + 1; j < N; j++) {
                if (nums[j] < nums[minIdx]) {
                    minIdx = j;
                }
            }
            // Swap the found minimum element with the first element
            int temp = nums[i];
            nums[i] = nums[minIdx];
            nums[minIdx] = temp;
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
