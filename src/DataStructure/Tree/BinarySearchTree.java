package DataStructure.Tree;

public class BinarySearchTree {
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

    BinarySearchTree(int value) {
        root = new Node(value);
    }

    BinarySearchTree() {
        root = null;
    }

    Node insert(Node root, int value) {
        if (root == null) {
            root = new Node(value);
        } else if (value <= root.data) {
            root.left = insert(root.left, value);
        } else {
            root.right = insert(root.right, value);
        }
        return root;
    }

    boolean search(Node root, int value) {
        if (root == null) {
            return false;
        } else if (value == root.data) {
            return true;
        } else if (value <= root.data) {
            return search(root.left, value);
        } else {
            return search(root.right, value);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.root = tree.insert(tree.root, 2);
        tree.root = tree.insert(tree.root, 1);
        tree.root = tree.insert(tree.root, 3);
        tree.root = tree.insert(tree.root, 4);
        tree.root = tree.insert(tree.root, 5);
        tree.root = tree.insert(tree.root, 6);

        int value = 1;
        System.out.println(value + (tree.search(tree.root, value) ? " is " : " is NOT ")
                + "in this tree");
    }
}
