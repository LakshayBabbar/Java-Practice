package Array;

import java.util.EmptyStackException;
import Exceptions.ElementNotFoundException;

public class Stack {
    private int top = -1, MAX_SIZE = 0;
    private int[] array;

    public Stack(int size) {
        this.MAX_SIZE = size;
        this.array = new int[size];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int getSize() {
        return top + 1;
    }

    public void push(int data) {
        if (top == MAX_SIZE - 1)
            throw new StackOverflowError("Stack overflow: Cannot push " + data);
        array[++top] = data;
    }

    public int pop() {
        if (isEmpty())
            throw new EmptyStackException();
        return array[top--];
    }

    public int peek() {
        if (isEmpty())
            throw new EmptyStackException();
        return array[top];
    }

    public int elementAt(int index) {
        if (index < 0 || index >= getSize()) {
            throw new IndexOutOfBoundsException();
        }
        return array[index];
    }

    public int contains(int element) {
        for (int i = 0; i < getSize(); i++) {
            if (array[i] == element)
                return i;
        }
        throw new ElementNotFoundException(element + " doesn't exists.");
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        StringBuilder str = new StringBuilder("[");
        for (int i = 0; i <= top; i++) {
            str.append(array[i]);
            if (i < top)
                str.append(", ");
        }
        str.append("]");
        return str.toString();
    }
}