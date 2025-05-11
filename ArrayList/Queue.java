package ArrayList;

import java.util.ArrayList;

public class Queue<T> {
    private int front = 0;
    private int rear = 0;
    private ArrayList<T> array = new ArrayList<>();
    private static final int CLEANUP_THRESHOLD = 20;

    public void add(T data) {
        array.add(data);
        rear++;
    }

    public T remove() {
        if (isEmpty())
            return null;
        T removed = array.get(front++);

        if (front >= CLEANUP_THRESHOLD) {
            cleanup();
        }

        return removed;
    }

    public T peek() {
        if (isEmpty())
            return null;
        return array.get(front);
    }

    public int size() {
        return rear - front;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public T elementAt(int idx) {
        if (isEmpty())
            return null;
        return array.get(idx);
    }

    private void cleanup() {
        array = new ArrayList<>(array.subList(front, rear));
        rear = size();
        front = 0;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }
        for (int i = front; i < rear; i++) {
            System.out.print(array.get(i) + "\t");
        }
        System.out.println();
        System.out.println("Front: " + array.get(front));
        System.out.println("Rear: " + array.get(rear - 1));
    }
}
