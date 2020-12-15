package DataStructure.Queue;

public class ArrayQueue {
    int front;
    int rear;
    int size;
    int capacity;
    int[] array;

    ArrayQueue(int capacity) {
        this.capacity = capacity;
        front = 0;
        rear = capacity - 1;
        size = 0;
        array = new int[this.capacity];
    }

    boolean isFull() {
        return size == capacity;
    }

    boolean isEmpty() {
        return size == 0;
    }

    int enqueue(int value) {
        if (isFull()) {
            System.out.println("Queue is full, can not enqueue");
            return Integer.MIN_VALUE;
        }
        rear = (rear + 1) % capacity;
        array[rear] = value;
        size++;
        return value;
    }

    int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty, can not dequeue");
            return Integer.MIN_VALUE;
        }
        int value = array[front];
        front = (front + 1) % capacity;
        size--;
        return value;
    }

    int getFront() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return Integer.MIN_VALUE;
        }
        return array[front];
    }

    int getRear() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return Integer.MIN_VALUE;
        }
        return array[rear];
    }

    int getSize() {
        return size;
    }

    void printQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        System.out.print("The Queue : ");
        for (int i = front; i <= rear; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
        System.out.println("Queue's size : " + getSize());
        System.out.println("Queue's Front : " + getFront());
        System.out.println("Queue's Rear : " + getRear());
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(100);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);

        queue.printQueue();

        System.out.println(queue.dequeue() + " is dequeued from Queue");
        queue.printQueue();

        System.out.println(queue.enqueue(7) + " is enqueued to Queue");
        queue.printQueue();

        System.out.println(queue.dequeue() + " is dequeued from Queue");
        queue.printQueue();
    }
}
