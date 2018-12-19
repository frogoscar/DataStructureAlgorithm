package DSAAJ.List;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyArrayList<T> implements Iterable<T> {
    private static final int DEFAULT_CAPACITY = 10;

    private int theSize;
    private T[] theItems;

    public MyArrayList() {
        doClear();
    }

    public void clear() {
        doClear();
    }

    private void doClear() {
        theSize = 0;
        ensureCapacity(DEFAULT_CAPACITY);
    }

    public int size() {
        return theSize;
    }

    public boolean isEmpty() {
        return theSize == 0;
    }

    public void trimToSize() {
        ensureCapacity(theSize);
    }

    public T get(int idx) {
        if (idx < 0 || idx > theSize) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return theItems[idx];
    }

    public T set(int idx, T newVal) {
        if (idx < 0 || idx > theSize) {
            throw new ArrayIndexOutOfBoundsException();
        }
        T old = theItems[idx];
        theItems[idx] = newVal;
        return old;
    }

    private void ensureCapacity(int newCapacity) {
        if (newCapacity < theSize) {
            return;
        }
        T[] old = theItems;
        theItems = (T[])new Object[newCapacity];
        for (int i = 0; i < theSize; i++) {
            theItems[i] = old[i];
        }
    }

    public boolean add(T x) {
        add(theSize, x);
        return true;
    }

    public void add(int idx, T x) {
        if (theItems.length == theSize) {
            ensureCapacity(theSize * 2 + 1);
        }
        for (int i = theSize; i > idx; i--) {
            theItems[i] = theItems[i - 1];
        }
        theItems[idx] = x;
        theSize++;
    }

    public T remove(int idx) {
        if (idx < 0 || idx > theSize) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (theSize == 0) {
            throw new NoSuchElementException();
        }
        T removed = theItems[idx];
        for (int i = idx; i < theSize - 1; i++) {
            theItems[i] = theItems[i + 1];
        }
        theSize--;
        return removed;
    }

    public Iterator<T> iterator() {
        return new ArrayListIterator();
    }

    // Working implementation of ArrayListIterator using Inner Class
    private class ArrayListIterator implements Iterator<T> {
        private int current = 0;

        public boolean hasNext() {
            return current < size();
        }

        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return theItems[current++];
        }

        public void remove() {
            MyArrayList.this.remove(--current);
        }
    }

    /* // Another working implementation of ArrayListIterator using static keyword (a nested class)
    public Iterator<T> iterator() {
        return new ArrayListIterator<>(this);
    }

    private static class ArrayListIterator<T> implements Iterator<T> {
        private int current = 0;
        private MyArrayList<T> theList;

        public ArrayListIterator(MyArrayList<T> list) {
            theList = list;
        }

        public boolean hasNext() {
            return current < theList.size();
        }

        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return theList.theItems[current++];
        }

        public void remove() {
            theList.remove(--current);
        }
    }
    */

    public static void main(String[] args) {
        MyArrayList<Integer> lst = new MyArrayList<>();

        for (int i = 0; i < 20; i++) {
            lst.add(i);
        }

        for (int i = 20; i < 30; i++) {
            lst.add(0, i);
        }

        lst.remove(0);
        lst.remove(lst.size() - 1);

        Iterator<Integer> iterator = lst.iterator();
        System.out.println("Print using Iterator");
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println("\nPrint using for loop");
        for (Integer i : lst) {
            System.out.print(i + " ");
        }
    }
}
