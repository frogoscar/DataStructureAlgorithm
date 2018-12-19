package DataStructure;

public class CircularQueue<T> {
    private T[] items;
    private int n = 0; // Size of array
    private int head = 0;
    private int tail = 0;

    public CircularQueue(int capacity) {
        items = (T[])new Object[capacity];
        n = capacity;
    }

    public boolean enqueue(T x) {
        if ((tail + 1) % n == head) {
            // Queue is full
            return false;
        }
        items[tail] = x;
        tail = (tail + 1) % n;
        return true;
    }

    public T dequeue() {
        if (head == tail) {
            // Queue is empty
            return null;
        }
        T res = items[head];
        head = (head + 1) % n;
        return res;
    }
}
