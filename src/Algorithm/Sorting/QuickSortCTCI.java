package Algorithm.Sorting;

// CTCI is short for Cracking The Coding Interview
public class QuickSortCTCI {
    static void quickSort(int[] arr, int left, int right) {
        int index = partition(arr, left, right);
        if (left < index - 1) {  // Sort left half
            quickSort(arr, left, index - 1);
        }
        if (index < right) {  // Sort right half
            quickSort(arr, index, right);
        }
    }

    static int partition(int[] arr, int left, int right) {
        int pivot = arr[left + (right - left) / 2];  // Pick pivot point
        while (left <= right) {
            // Find element on left that should be on right
            while (arr[left] < pivot) {
                left++;
            }

            // Find element on right that should be on left
            while (pivot < arr[right]) {
                right--;
            }

            // Swap elements, and move left and right indices
            if (left <= right) {
                swap(arr, left, right);
                left++;
                right--;
            }
        }
        return left;
    }

    static void swap(int[] arr, int x, int y) {
        int tmp = arr[x];
        arr[x] = arr[y];
        arr[y] = tmp;
    }

    static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 15, 1, 5, 2};
        int n = arr.length;

        System.out.println("Original array");
        printArray(arr);

        quickSort(arr, 0, n - 1);

        System.out.println("\nSorted array");
        printArray(arr);
    }
}
