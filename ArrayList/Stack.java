package ArrayList;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class Stack<T> {
    private int top = -1;
    private ArrayList<T> array = new ArrayList<>();

    public void push(T data) {
        array.add(data);
        top++;
    }

    public T pop() {
        if (isEmpty())
            return null;

        return array.remove(top--);
    }

    public T peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return null;
        }
        return array.getLast();
    }

    public boolean contains(T data) {
        if (isEmpty())
            return false;
        return array.contains(data);
    }

    public T elementAt(int index) {
        if (isEmpty())
            throw new EmptyStackException();
        if (index < 0 || index >= size())
            throw new IndexOutOfBoundsException();
        return array.get(index);
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return;
        }
        StringBuilder str = new StringBuilder("[");
        for (int i = 0; i <= top; i++) {
            str.append(array.get(i));
            if (i < size() - 1)
                str.append(", ");
        }
        str.append("]");
        System.out.println(str);
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int size() {
        return top + 1;
    }
}
