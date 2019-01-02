package Algorithm.TwoPointersTech;

// Given a sorted array A (sorted in ascending order),
// find if there exists any pair of elements (A[i], A[j])
// such that their sum is equal to val
public class PairSum {
    // Time : O(n^2)
    static boolean isPairSumNaive(int[] a, int val) {
        for (int i : a) {
            for (int j : a) {
                if (i + j == val) {
                    return true; // pair exists
                }
                if (i + j > val) {
                    break; // as the array is sorted
                }
            }
        }

        // No pair found with given sum.
        return false;
    }

    // Time : O(n)
    static boolean isPairSumAdvanced(int[] a, int val) {
        int N = a.length;
        int i = 0;
        int j = N - 1;

        while (i < j) {
            if (a[i] + a[j] == val) {
                return true;
            } else if (a[i] + a[j] > val) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] a = {10, 20, 30, 40, 50, 60};
        int val = 70;
        for (int i : a) {
            System.out.print(i + " ");
        }
        System.out.println();
        if (isPairSumAdvanced(a, val)) {
            System.out.println("Array has pair of number whose sum is " + val);
        } else {
            System.out.println("Array does not have pair of number whose sum is " + val);
        }
    }
}
