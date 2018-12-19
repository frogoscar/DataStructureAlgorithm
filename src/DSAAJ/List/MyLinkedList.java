package DSAAJ.List;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<T> implements Iterable<T> {
    private class Node<T> {
        private T data;
        private Node<T> prev;
        private Node<T> next;

        public Node(T d, Node<T> p, Node<T> n) {
            data = d;
            prev = p;
            next = n;
        }
    }

    private int theSize;
    /*
    One additional data field that is used to help the iterator
    detect changes in the collection. modCount represents the number of changes to
    the linked list since construction. Each call to add or remove will update modCount.
    The idea is that when an iterator is created, it will store the modCount of the collection.
    Each call to an iterator method (next or remove) will check the stored modCount in the
    iterator with the current modCount in the linked list and will throw a
    ConcurrentModificationException if these two counts don’t match.
     */
    private int modCount = 0;    // Means modification count
    private Node<T> beginMarker;
    private Node<T> endMarker;

    public MyLinkedList() {
        doClear();
    }

    public void clear() {
        doClear();
    }

    private void doClear() {
        beginMarker = new Node<T>(null, null, null);
        endMarker = new Node<T>(null, beginMarker, null);
        beginMarker.next = endMarker;

        theSize = 0;
        modCount++;
    }

    public int size() {
        return theSize;
    }

    public boolean isEmpty() {
        return theSize == 0;
    }

    public boolean add(T x) {
        add(theSize, x);
        return true;
    }

    public void add(int idx, T x) {
        addBefore(getNode(idx, 0, theSize), x);
    }

    public T get(int idx) {
        return getNode(idx).data;
    }

    public T set(int idx, T newVal) {
        Node<T> p = getNode(idx);
        T oldVal = p.data;
        p.data = newVal;
        return oldVal;
    }

    public T remove(int idx) {
        return remove(getNode(idx));
    }

    private void addBefore(Node<T> p, T x) {
        Node<T> newNode = new Node<T>(x, p.prev, p);
        //newNode.prev.next = newNode;
        p.prev.next = newNode;
        p.prev = newNode;
        theSize++;
        modCount++;
    }

    private T remove (Node<T> p) {
        p.prev.next = p.next;
        p.next.prev = p.prev;
        theSize--;
        modCount++;
        return p.data;
    }

    private Node<T> getNode(int idx) {
        return getNode(idx, 0, theSize - 1);
    }

    private Node<T> getNode(int idx, int lower, int upper) {
        Node<T> p;
        if (idx < lower || idx > upper) {
            throw new IndexOutOfBoundsException();
        }
        if (idx < theSize / 2) {
            p = beginMarker.next;
            for (int i = 0; i < idx; i++) {
                p = p.next;
            }
        } else {
            p = endMarker;
            for (int i = theSize; i > idx; i--) {
                p = p.prev;
            }
        }
        return p;
    }

    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<T> {
        private Node<T> current = beginMarker.next;
        private int expectedModCount = modCount;
        private boolean okToRemove = false;

        public boolean hasNext() {
            return current != endMarker;
        }

        public T next() {
            if (modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T nextItem = current.data;
            current = current.next;
            okToRemove = true;
            return nextItem;
        }

        public void remove() {
            if (modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }
            if (!okToRemove) {
                throw new IllegalStateException();
            }
            MyLinkedList.this.remove(current.prev);
            expectedModCount++;
            okToRemove = false;
        }
    }

    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();

        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        for (int i = 20; i < 30; i++) {
            list.add(0, i);
        }

        list.remove(0);
        list.remove(list.size() - 1);

        System.out.println("\nPrint using for loop");
        for (Integer i : list) {
            System.out.print(i + " ");
        }
        System.out.println();

        System.out.println("\nPrint using Iterator");
        Iterator<Integer> itr = list.iterator();
        while (itr.hasNext()) {
            itr.next();
            itr.remove();
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
