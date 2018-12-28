package Algorithm.Search;

public class BinarySearch {
    // Time complexity : O(logN)
    static int binarySearch(int[] arr, int value) {
        int left = 0;
        int right = arr.length - 1;
        int mid;

        while (left <= right) {
            // This is more safe than mid = (left + right) / 2;
            // because (left + right) might overflow when the integer is big
            mid = left + (right - left) / 2;

            if (arr[mid] > value) {
                right = mid - 1;
            } else if (arr[mid] < value) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    static int binarySearchRecursive(int[] arr, int value, int low, int high) {
        if (low > high) {
            return -1;  // Error
        }

        int mid = low + (high - low) / 2;

        if (value > arr[mid]) {
            return binarySearchRecursive(arr, value, mid + 1, high);
        } else if (value < arr[mid]) {
            return binarySearchRecursive(arr, value, low, mid - 1);
        } else {
            return mid;
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 4, 6, 7, 10, 12, 15};
        int value1 = 4;
        int value2 = 7;
        int value3 = 15;
        int value4 = 8;
        int value5 = 20;

        System.out.println(value1 + " index in array : "
                + binarySearch(array, value1));
        System.out.println(value2 + " index in array : "
                + binarySearch(array, value2));
        System.out.println(value3 + " index in array : "
                + binarySearch(array, value3));
        System.out.println(value4 + " index in array : "
                + binarySearch(array, value4));
        System.out.println(value5 + " index in array : "
                + binarySearch(array, value5));

        System.out.println();

        int value6 = 1;
        int value7 = 12;

        System.out.println(value6 + " index in array : "
                + binarySearchRecursive(array, value6, 0, array.length - 1));
        System.out.println(value7 + " index in array : "
                + binarySearchRecursive(array, value7, 0, array.length - 1));
    }
}
