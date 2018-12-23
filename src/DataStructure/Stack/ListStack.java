package DataStructure.Stack;

import java.util.Iterator;
import java.util.NoSuchElementException;

// LinkedList implementation of stack with generics <T>
class ListStack<T> implements Iterable<T> {
    private Node<T> top;

    static class Node<T> {
        T data;
        Node<T> next;
        Node(T value) {
            data = value;
        }
    }

    void pop() {
        if (top == null) {
            return;
        }
        top = top.next;
    }

    void push(T value) {
        Node<T> node = new Node(value);
        node.next = top;
        top = node;
    }

    boolean empty() {
        return top == null;
    }

    T peek() {
        if (empty()) {
            throw new NoSuchElementException("Stack Underflow");
        }
        return top.data;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (T t : this) {
            s.append(t);
            s.append(" ");
        }
        return s.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator<T>(top);
    }

    class ListIterator<T> implements Iterator<T> {
        Node<T> current;

        ListIterator(Node<T> top) {
            current = top;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T t = current.data;
            current = current.next;
            return t;
        }
    }

    public static void main(String[] args) {
        ListStack<Integer> stack = new ListStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println("Stack : " + stack.toString());
        System.out.println();
        System.out.println("Top element : " + stack.peek());
        stack.pop();
        stack.pop();
        System.out.println();
        System.out.println("Top element : " + stack.peek());
        System.out.println();
        System.out.println("Stack : " + stack.toString());
    }
}

