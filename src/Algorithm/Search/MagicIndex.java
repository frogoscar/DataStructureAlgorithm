package Algorithm.Search;

// A magic index in an array A[1...n-1] is defined to be an index
// such that A[i] = i. Given an sorted array of distinct integers
// Find a magic index.

// Solution : This is a Binary Search Problem.
public class MagicIndex {

    static int magicFast(int[] arr) {
        return magicFast(arr, 0, arr.length - 1);
    }

    static int magicFast(int[] arr, int low, int high) {
        if (low > high) {
            return -1;
        }

        int mid = low + (high - low) / 2;
        if (arr[mid] == mid) {
            return mid;
        } else if (arr[mid] > mid) {
            return magicFast(arr, low, mid - 1);
        } else {
            return magicFast(arr, mid + 1, high);
        }
    }

    public static void main(String[] args) {
        int[] arr = {-40, -20, -1, 1, 2, 3, 5, 7, 9, 12, 13};
        System.out.println("Magic Index is " + magicFast(arr));
    }
}
