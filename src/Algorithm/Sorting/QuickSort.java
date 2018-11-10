package Algorithm.Sorting;

import java.util.concurrent.ThreadLocalRandom;

class QuickSort {
    /* This function takes random number between
    [min, max] as pivot, places the pivot element at its correct
    position in sorted array, and places all smaller
    (smaller than pivot) to left of pivot and all
    greater elements to right of pivot */
    int randomizedPartition(int arr[], int low, int high) {
        int randomNum = ThreadLocalRandom.current().nextInt(low, high + 1);
        int temp = arr[randomNum];
        arr[randomNum] = arr[high];
        arr[high] = temp;
        return partition(arr, low, high);
    }

    // Normally we can use this partition method
    // which takes the last element as a pivot, but better
    // using the randomizedPartition method to avoid worst case
    int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = (low - 1); // index of smaller element
        for (int j = low; j < high; j++) {
            // If current element is smaller than or
            // equal to pivot
            if (arr[j] <= pivot) {
                i++;
                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    /* The main function that implements QuickSort()
    arr[] --> Array to be sorted,
    low --> Starting index,
    high --> Ending index */
    void sort(int arr[], int low, int high) {
        if (low < high) {
			/* pi is partitioning index, arr[pi] is
			now at right place */
            int pi = randomizedPartition(arr, low, high);

            // Recursively sort elements before
            // partition and after partition
            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
    }

    static void printArray(int arr[]) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        int arr[] = {10, 7, 8, 9, 15, 1, 5, 2};
        int n = arr.length;

        System.out.println("Original array");
        printArray(arr);

        QuickSort ob = new QuickSort();
        ob.sort(arr, 0, n - 1);

        System.out.println("Sorted array");
        printArray(arr);
    }
}
