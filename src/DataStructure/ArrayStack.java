package DataStructure;

// Array implementation of stack
class ArrayStack {
    static final int MAX = 100;
    int[] array;
    int top;

    ArrayStack() {
        array = new int[MAX];
        top = -1;
    }

    void push(int value) {
        if (isFull()) {
            System.out.println("Stack is full, can not push");
            return;
        }
        array[++top] = value;
    }

    void pop() {
        if (isEmpty()) {
            System.out.println("Empty stack, can not pop");
            return;
        }
        System.out.print(array[top--] + " ");
    }

    boolean isEmpty() {
        return top == -1;
    }

    boolean isFull() {
        return top == MAX - 1;
    }

    void reversePrint() {
        while (!isEmpty()) {
            pop();
        }
    }

    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.reversePrint();
    }
}

