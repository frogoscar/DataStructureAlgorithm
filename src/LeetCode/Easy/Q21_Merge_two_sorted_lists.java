package LeetCode.Easy;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class Q21_Merge_two_sorted_lists {

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    // 方法一：递归
    // 两个链表头部值较小的一个节点与剩下元素的 merge 操作结果合并
    // 时间复杂度 : O(n + m)
    // 空间复杂度 : O(n + m)
    static ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    // 方法二：迭代
    // 时间复杂度 : O(n + m)
    // 空间复杂度 : O(1)
    // 思路:
    // 我们可以用迭代的方法来实现上述算法。当 l1 和 l2 都不是空链表时，
    // 判断 l1 和 l2 哪一个链表的头节点的值更小，将较小值的节点添加到结果里，
    // 当一个节点被添加到结果里之后，将对应链表中的节点向后移一位。
    static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 首先，我们设定一个哨兵节点 prehead
        ListNode prehead = new ListNode(-1);

        // 维护一个 prev 指针，我们需要做的是调整它的 next 指针
        ListNode prev = prehead;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        // 合并后 l1 和 l2 最多只有一个还未被合并完，
        // 我们直接将链表末尾指向未合并完的链表即可
        prev.next = l1 == null ? l2 : l1;

        return prehead.next;
    }

    public static void main(String[] args) {

    }

}
