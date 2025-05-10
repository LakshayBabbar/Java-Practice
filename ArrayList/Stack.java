package ArrayList;

import java.util.ArrayList;

public class Stack<T> {
    private int top = -1;
    private ArrayList<T> array = new ArrayList<>();

    public void push(T data) {
        array.add(data);
        top++;
    }

    public void pop() {
        if (isEmpty())
            return;
        array.remove(top--);
    }

    public T peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return null;
        }
        return array.getLast();
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return;
        }
        for (int i = 0; i <= top; i++) {
            System.out.print(array.get(i) + "\t");
        }
        System.out.println();
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int size() {
        return top + 1;
    }
}
