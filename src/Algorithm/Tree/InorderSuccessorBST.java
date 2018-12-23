package Algorithm.Tree;

public class InorderSuccessorBST {
    class Node {
        int data;
        Node left;
        Node right;
        Node parent;
        Node(int value) {
            data = value;
            left = right = parent = null;
        }
    }

    Node insert(Node node, int value) {
        // If tree is empty
        if (node == null) {
            return new Node(value);
        }
        Node temp;
        if (value <= node.data) {
            temp = insert(node.left, value);
            node.left = temp;
        } else {
            temp = insert(node.right, value);
            node.right = temp;
        }
        temp.parent = node;
        return node;
    }

    /* Given a non-empty binary search tree, return the minimum data
     value found in that tree. Note that the entire tree does not need
     to be searched.
     */
    Node minValue(Node node) {
        Node current = node;

        // Loop down to find the leftmost leaf
        while (current.left != null) {
            current = current.left;
        }

        return current;
    }

    Node inOrderSuccessor(Node n) {
        if (n.right != null) {
            return minValue(n.right);
        }
        Node p = n.parent;
        while (p != null && n == p.right) {
            n = p;
            p = p.parent;
        }
        return p;
    }

    public static void main(String[] args) {
        InorderSuccessorBST tree = new InorderSuccessorBST();
        Node root = null, temp, suc, min;
        root = tree.insert(root, 20);
        root = tree.insert(root, 8);
        root = tree.insert(root, 22);
        root = tree.insert(root, 4);
        root = tree.insert(root, 12);
        root = tree.insert(root, 10);
        root = tree.insert(root, 14);
        temp = root.left.right.right;
        suc = tree.inOrderSuccessor(temp);
        if (suc != null) {
            System.out.println("Inorder successor of " + temp.data +
                    " is " + suc.data);
        } else {
            System.out.println("Inorder successor does not exist");
        }
    }
}
