package DataStructure.Queue;

public class ListQueue {
    Node front;
    Node rear;

    class Node {
        int data;
        Node next;
        Node(int value) {
            data = value;
        }
    }

    public ListQueue() {
        front = rear = null;
    }

    void enqueue(int value) {
        Node node = new Node(value);
        if (rear == null) {
            front = rear = node;
            return;
        }
        rear.next = node;
        rear = rear.next;
    }

    int dequeue() {
        if (front == null) {
            System.out.println("Queue is empty");
            return Integer.MIN_VALUE;
        }
        int value = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        return value;
    }

    public static void main(String[] args) {
        ListQueue queue = new ListQueue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);

        System.out.println(queue.dequeue() + " dequeued from Queue");
        System.out.println(queue.dequeue() + " dequeued from Queue");
        System.out.println(queue.dequeue() + " dequeued from Queue");
        System.out.println(queue.dequeue() + " dequeued from Queue");
        System.out.println(queue.dequeue() + " dequeued from Queue");

        System.out.println(queue.dequeue() + " dequeued from Queue");
    }
}
