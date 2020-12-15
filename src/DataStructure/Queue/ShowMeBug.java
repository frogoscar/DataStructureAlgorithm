package DataStructure.Queue;

// ArrayQueue 的拷贝，为了面试别人
// 用数组实现一个队列，需要入队和出队的时间复杂度都是 O(1)
public class ShowMeBug {
    static class ArrayQueue {
        int front;     // 队列头
        int rear;      // 队列尾
        int size;      // 队列现有长度
        int capacity;  // 队列最大容量
        int[] array;   // 数组，模拟队列

        // 构造函数
        ArrayQueue(int capacity) {
            this.capacity = capacity;
            front = 0;
            rear = -1;  // 或 capacity - 1
            size = 0;
            array = new int[capacity];
        }

        // 判断队列是否已满
        boolean isFull() {
            return size == capacity;
        }

        // 判断队列是否为空
        boolean isEmpty() {
            return size == 0;
        }

        // 入队。返回值为入队的元素
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

        // 出队。返回值为出队的元素
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

        // 获取队头元素
        int getFront() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return Integer.MIN_VALUE;
            }
            return array[front];
        }

        // 获取队尾元素
        int getRear() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return Integer.MIN_VALUE;
            }
            return array[rear];
        }

        // 获取队列里面现有的元素个数
        int getSize() {
            return size;
        }

        // 打印队列
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
