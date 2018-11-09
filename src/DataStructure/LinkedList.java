package DataStructure;

import java.util.Stack;

public class LinkedList {
    private Node head;

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
        }
    }

    void printList() {
        Node n = head;
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
    }

    void insertAtHead(int value) {
        Node node = new Node(value);
        node.next = head;
        head = node;
    }

    void insertAfter(Node prev, int value) {
        if (prev == null) {
            System.out.println("The previous node can not be null");
            return;
        }
        Node node = new Node(value);
        node.next = prev.next;
        prev.next = node;
    }

    void insertAtTail(int value) {
        Node node = new Node(value);

        if (head == null) {
            head = node;
            return;
        }

        Node last = head;

        while (last.next != null) {
            last = last.next;
        }
        last.next = node;
    }

    int count() {
        if (head == null) {
            return 0;
        }
        int count = 0;
        Node node = head;
        while (node != null) {
            count++;
            node = node.next;
        }
        return count;
    }

    void removeAtHead() {
        if (head == null) {
            return;
        }
        head = head.next;
    }

    void removeAtTail() {
        if (head == null) {
            return;
        }
        Node prev = head;
        while (prev.next.next != null) {
            prev = prev.next;
        }
        prev.next = null;
    }

    void removeAfter(Node prev) {
        if (prev == null) {
            System.out.println("The previous node can not be null");
            return;
        }
        if (prev.next == null) {
            System.out.println("The node after is null, can not remove");
            return;
        }
        prev.next = prev.next.next;
    }

    void removeWithValue(int value) {
        if (head == null) {
            return;
        }
        Node prev = head;
        while (prev.next != null) {
            if (prev.next.data == value) {
                break;
            }
            prev = prev.next;
        }
        if (prev.next == null) {
            return;
        }
        prev.next = prev.next.next;
    }

    void reversePrintUsingStack() {
        Stack<Integer> stack = new Stack<>();
        Node node = head;
        while (node != null) {
            stack.push(node.data);
            node = node.next;
        }
        while (!stack.empty()) {
            System.out.print(stack.peek() + " ");
            stack.pop();
        }
    }

    // Iterative reverse
    void iterativeReverseList() {
        Node prev = null;
        while (head != null) {
            Node next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        head = prev;
    }

    // Recursive reverse
    Node recursiveReverseList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node p = recursiveReverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    public static void main(String[] args) {
        LinkedList lList = new LinkedList();

        // Insert 6.  So linked list becomes 6->NUll
        lList.insertAtTail(6);

        // Insert 7 at the beginning. So linked list becomes
        // 7->6->NUll
        lList.insertAtHead(7);

        // Insert 1 at the beginning. So linked list becomes
        // 1->7->6->NUll
        lList.insertAtHead(1);

        // Insert 4 at the end. So linked list becomes
        // 1->7->6->4->NUll
        lList.insertAtTail(4);

        // Insert 8, after 7. So linked list becomes
        // 1->7->8->6->4->NUll
        lList.insertAfter(lList.head.next, 8);

        System.out.println("\nCreated Linked List : ");
        lList.printList();
        System.out.println();
        System.out.println("\nLinked list has " + lList.count() + " nodes");

        System.out.println("\nReverse print Linked List using Stack : ");
        lList.reversePrintUsingStack();
        System.out.println();
        System.out.println("\nLinked list has " + lList.count() + " nodes");

        // Remove 4. So linked list becomes
        // 1->7->8->6->NUll
        lList.removeAtTail();
        System.out.println("\nLinked list after removeAtTail is: ");
        lList.printList();
        System.out.println();
        System.out.println("\nLinked list has " + lList.count() + " nodes");

        // Remove 7. So linked list becomes
        // 1->8->6->NUll
        lList.removeAfter(lList.head);
        System.out.println("\nLinked list after removeAfter(lList.head) is: ");
        lList.printList();
        System.out.println();
        System.out.println("\nLinked list has " + lList.count() + " nodes");

        // Remove 8. So linked list becomes
        // 1->6->NUll
        lList.removeWithValue(8);
        System.out.println("\nLinked list after removeWithValue(8) is: ");
        lList.printList();
        System.out.println();
        System.out.println("\nLinked list has " + lList.count() + " nodes");

        // Insert 10 at tail. So linked list becomes
        // 1->6->10->NUll
        lList.insertAtTail(10);
        System.out.println("\nLinked list after insertAtTail(10) is: ");
        lList.printList();
        System.out.println();
        System.out.println("\nLinked list has " + lList.count() + " nodes");

        // Remove 1. So linked list becomes
        // 6->10->NUll
        lList.removeAtHead();
        System.out.println("\nLinked list after removeAtHead() is: ");
        lList.printList();
        System.out.println();
        System.out.println("\nLinked list has " + lList.count() + " nodes");

        // Remove 9 at Head and 4 at Tail. So linked list becomes
        // 9->6->10->4->NUll
        lList.insertAtHead(9);
        lList.insertAtTail(4);
        System.out.println("\nLinked list after removeAtHead() is: ");
        lList.printList();
        System.out.println();

        // Iterative reverse Linked List. So linked list becomes
        // 4->10->6->9->NUll
        lList.iterativeReverseList();
        System.out.println("\nLinked list after iterativeReverseList() is: ");
        lList.printList();
        System.out.println();

        // Recursive reverse Linked List. So linked list becomes
        // 9->6->10->4->NUll
        lList.head = lList.recursiveReverseList(lList.head);
        System.out.println("\nLinked list after recursiveReverseList() is: ");
        lList.printList();
        System.out.println();
    }
}
