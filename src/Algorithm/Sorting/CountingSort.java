package Algorithm.Sorting;

public class CountingSort {
    static void sort(int[] nums, int n) {
        int[] arr = new int[n];
        for (int i : nums) {
            arr[i]++;
        }
        int j = 0;
        for (int i = 0; i < n; i++) {
            int num = arr[i];
            while (num-- > 0) {
                nums[j++] = i;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 0, 1, 2, 1, 1, 0, 2, 0, 1, 2, 1, 0};
        sort(arr, 3);
        System.out.println("Sorted character array is ");
        for (int i : arr) {
            System.out.print(i);
        }
    }
}
