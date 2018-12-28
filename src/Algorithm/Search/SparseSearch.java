package Algorithm.Search;

// Given a sorted array of strings which is interspersed
// with empty strings, write a method to find the
// location of a given string.
public class SparseSearch {
    static int binarySearch(String[] arr, String target, int low, int high) {
        if (low > high) {
            return -1;
        }

        int mid = low + (high - low) / 2;

        // Modified Part
        if (arr[mid].equals("")) {
            int left = mid - 1;
            int right = mid + 1;

            // Search for both side for a non empty string
            while (true) {
                // No non-empty string on both sides
                if (left < low && right > high) {
                    return -1;
                }

                if (left >= low && !arr[left].equals("")) {
                    mid = left;
                    break;
                }

                if (right <= high && !arr[right].equals("")) {
                    mid = right;
                    break;
                }

                left--;
                right++;
            }
        }

        // Normal Binary Search
        if (target.equals(arr[mid])) {
            return mid;
        } else if (target.compareTo(arr[mid]) < 0) {
            return binarySearch(arr, target, low, mid - 1);
        } else {
            return binarySearch(arr, target, mid + 1, high);
        }
    }

    public static void main(String[] args) {
        String[] sparseArray = {"for", "geeks", "", "", "", "", "ide",
                "practice", "", "", "", "quiz"};
        String target = "quiz";
        int index = binarySearch(sparseArray, target, 0, sparseArray.length - 1);
        if (index != -1) {
            System.out.println(target + " found at index " + index);
        } else {
            System.out.println(target + " not found ");
        }
    }
}
