package DSAAJ.Heap;

public class BinaryHeap<T extends Comparable<? super T>> {
    private static final int DEFAULT_CAPACITY = 10;
    private int currentSize;  // Number of elements in heap
    private T[] array;  // The heap array

    public BinaryHeap() {
        this(DEFAULT_CAPACITY);
    }

    public BinaryHeap(int capacity) {
        currentSize = 0;
        array = (T[])new Comparable[capacity + 1];
    }

    public BinaryHeap(T[] items) {
        currentSize = items.length;
        array = (T[])new Comparable[(currentSize + 2)
                * (DEFAULT_CAPACITY + 1) / 10];
        int i = 1;
        for (T item : items) {
            array[i++] = item;
        }
        //buildHeap();
    }
}
