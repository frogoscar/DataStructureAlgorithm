package LeetCode.Easy;

import java.util.Arrays;

public class Q88_Merge_two_sorted_arrays {

//    // 方法一 : 合并后排序
//    // 这种方法没有利用两个数组本身已经有序这一点
//    // 时间复杂度 : O((n+m)log(n+m))
//    // 空间复杂度 : O(1)
//    static void merge1(int[] nums1, int m, int[] nums2, int n) {
//        System.arraycopy(nums2, 0, nums1, m, n);
//        Arrays.sort(nums1);
//    }
//
//    // 方法二 : 双指针 / 从前往后
//    // 时间复杂度 : O(n + m)
//    // 空间复杂度 : O(m)
//    static void merge2(int[] nums1, int m, int[] nums2, int n) {
//        // Make a copy of nums1.
//        int [] nums1_copy = new int[m];
//        System.arraycopy(nums1, 0, nums1_copy, 0, m);
//
//        // Two get pointers for nums1_copy and nums2.
//        int p1 = 0;
//        int p2 = 0;
//
//        // Set pointer for nums1
//        int p = 0;
//
//        // Compare elements from nums1_copy and nums2
//        // and add the smallest one into nums1.
//        while ((p1 < m) && (p2 < n))
//            nums1[p++] = (nums1_copy[p1] < nums2[p2]) ? nums1_copy[p1++] : nums2[p2++];
//
//        // if there are still elements to add
//        if (p1 < m)
//            System.arraycopy(nums1_copy, p1, nums1, p1 + p2, m + n - p1 - p2);
//        if (p2 < n)
//            System.arraycopy(nums2, p2, nums1, p1 + p2, m + n - p1 - p2);
//    }

    // 方法三 : 双指针 / 从后往前
    // 时间复杂度 : O(n + m)
    // 空间复杂度 : O(1)
    static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int p = m + n - 1;

        while (p1 >= 0 && p2 >= 0) {
            nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];
        }

        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 7, 0, 0, 0};
        int m = 4;
        int[] nums2 = {2, 5, 6};
        int n = 3;

        for (int i : nums1) {
            System.out.print(i + " ");
        }

        System.out.println();

        merge(nums1, m, nums2, n);

        for (int i : nums1) {
            System.out.print(i + " ");
        }
    }
}
