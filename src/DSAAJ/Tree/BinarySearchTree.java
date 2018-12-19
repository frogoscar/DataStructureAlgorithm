package DSAAJ.Tree;

import java.util.NoSuchElementException;

public class BinarySearchTree<T extends Comparable<? super T>> {
    private class BinaryNode<T> {
        T element;
        BinaryNode<T> left;
        BinaryNode<T> right;

        BinaryNode(T element) {
            this(element, null, null);
        }

        BinaryNode(T element, BinaryNode<T> lt, BinaryNode<T> rt) {
            this.element = element;
            left = lt;
            right = rt;
        }
    }

    private BinaryNode<T> root;

    public BinarySearchTree() {
        root = null;
    }

    public void makeEmpty() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean contains(T x) {
        return contains(x, root);
    }

    public T findMin() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return findMin(root).element;
    }

    public T findMax() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return findMax(root).element;
    }

    public void insert(T x) {
        root = insert(x, root);
    }

    public void remove(T x) {
        root = remove(x, root);
    }

    public void printTree() {
        if (isEmpty()) {
            System.out.println("Empty tree");
        } else {
            printTree(root);
        }
    }

    public int height(BinaryNode<T> t) {
        if (t == null) {
            return -1;
        }
        return 1 + Math.max(height(t.left), height(t.right));
    }

    private boolean contains(T x, BinaryNode<T> t) {
        if (t == null) {
            return false;
        }
        int compareResult = x.compareTo(t.element);
        if (compareResult < 0) {
            return contains(x, t.left);
        } else if (compareResult > 0) {
            return contains(x, t.right);
        } else {
            return true;
        }
    }

    private BinaryNode<T> findMin(BinaryNode<T> t) {
        if (t == null || t.left == null) {
            return t;
        }
        return findMin(t.left);
    }

    private BinaryNode<T> findMax(BinaryNode<T> t) {
        if (t != null) {
            while (t.right != null) {
                t = t.right;
            }
        }
        return t;
    }

    private BinaryNode<T> insert(T x, BinaryNode<T> t) {
        if (t == null) {
            return new BinaryNode<>(x);
        }
        int compareResult = x.compareTo(t.element);
        if (compareResult < 0) {
            t.left = insert(x, t.left);
        } else if (compareResult > 0) {
            t.right = insert(x, t.right);
        } else {
            // Duplication, do nothing
        }
        return t;
    }

    private BinaryNode<T> remove(T x, BinaryNode<T> t) {
        if (t == null) {
            return t;
        }
        int compareResult = x.compareTo(t.element);
        if (compareResult < 0) {
            t.left = remove(x, t.left);
        } else if (compareResult > 0) {
            t.right = remove(x, t.right);
        } else if (t.left != null && t.right != null) { // Two children
            t.element = findMin(t.right).element;
            t.right = remove(t.element, t.right);
        } else {
            // One child or no children
            t = (t.left != null) ? t.left : t.right;
        }
        return t;
    }

    // In-Order traversal
    private void printTree(BinaryNode<T> t) {
        if (t != null) {
            printTree(t.left);
            System.out.println(t.element);
            printTree(t.right);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> t = new BinarySearchTree<>();
        final int NUMS = 4000;
        final int GAP = 37;

        System.out.println("Checking... (no more output means success)");

        for (int i = GAP; i != 0; i = (i + GAP) % NUMS) {
            t.insert(i);
        }

        for (int i = 1; i < NUMS; i+=2) {
            t.remove(i);
        }

        if (t.findMin() != 2 || t.findMax() != NUMS - 2) {
            System.out.println("FindMin or FindMax error!");
        }

        for (int i = 2; i < NUMS; i+=2) {
            if (!t.contains(i)) {
                System.out.println("Find error1!");
            }
        }

        for (int i = 1; i < NUMS; i+=2) {
            if (t.contains(i)) {
                System.out.println("Find error2!");
            }
        }
    }
}
