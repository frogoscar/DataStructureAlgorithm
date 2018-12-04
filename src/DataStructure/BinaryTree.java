package DataStructure;

import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class BinaryTree {
    Node root;

    static class Node {
        int data;
        Node left;
        Node right;
        Node(int value) {
            data = value;
            left = right = null;
        }
    }

    BinaryTree(int value) {
        root = new Node(value);
    }

    BinaryTree() {
        root = null;
    }

    int getHeight(Node node) {
        if (node == null) {
            return -1;
        }
        return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }

    // Breadth First Traversal / Level Order Traversal
    void BFT(Node node) {
        if (node == null) {
            return;
        }
        // Use a Queue
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node current = queue.peek();
            System.out.print(current.data + " ");
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
            queue.poll();
        }
    }

    static List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int levelSize = queue.size();
            for (int i = 1; i <= levelSize; i++) {
                Node node = queue.poll();
                list.add(node.data);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(list);
        }
        return result;
    }

    // Pre-Order Traversal
    void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    // In-Order Traversal
    void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

    // In-Order Traversal
    void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data + " ");
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);

        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.left.left.left = new Node(6);

        System.out.println("BFT (Level Order) of Tree : ");
        tree.BFT(tree.root);
        System.out.println();
        System.out.println();

        System.out.println("PreOrder of Tree : ");
        tree.preOrder(tree.root);
        System.out.println();
        System.out.println();

        System.out.println("InOrder of Tree : ");
        tree.inOrder(tree.root);
        System.out.println();
        System.out.println();

        System.out.println("PostOrder of Tree : ");
        tree.postOrder(tree.root);
        System.out.println();
        System.out.println();

        System.out.println("Root's height is " + tree.getHeight(tree.root) + "\n");
        System.out.println("Root's left's height is " + tree.getHeight(tree.root.left) + "\n");

        System.out.println("Beautiful Level Order of Tree : ");
        System.out.println(levelOrder(tree.root));
    }
}
