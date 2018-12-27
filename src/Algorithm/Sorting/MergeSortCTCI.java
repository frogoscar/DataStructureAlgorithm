package Algorithm.Sorting;

// CTCI is short for Cracking The Coding Interview
public class MergeSortCTCI {
    static void mergeSort(int[] array) {
        int[] helper = new int[array.length];
        mergeSort(array, helper, 0, array.length - 1);
    }

    static void mergeSort(int[] array, int[] helper, int low, int high) {
        if (low < high) {
            int middle = low + (high - low) / 2;
            mergeSort(array, helper, low, middle);  // Sort left half
            mergeSort(array, helper, middle + 1, high);  // Sort right half
            merge(array, helper, low, middle, high);  // Merge them
        }
    }

    static void merge(int[] array, int[] helper, int low, int middle, int high) {
        // Copy both halves into a helper array
        for (int i = low; i <= high; i++) {
            helper[i] = array[i];
        }

        int helperLeft = low;
        int helperRight = middle + 1;
        int current = low;

        // Iterate through helper array. Compare the left and right half, copying
        // back the smaller element from the two halves into the original array
        while (helperLeft <= middle && helperRight <= high) {
            if (helper[helperLeft] <= helper[helperRight]) {
                array[current++] = helper[helperLeft++];
            } else {  // If right element is smaller than left element
                array[current++] = helper[helperRight++];
            }
        }

        // Copy the rest of the left side of the array into the original array
        int remaining = middle - helperLeft;
        for (int i = 0; i <= remaining; i++) {
            array[current + i] = helper[helperLeft + i];
        }
    }

    static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {8, 12, 11, 13, 5, 6, 7, 1};

        System.out.println("Given Array");
        printArray(arr);

        mergeSort(arr);

        System.out.println("\nSorted array");
        printArray(arr);
    }
}
