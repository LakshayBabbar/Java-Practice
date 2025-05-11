package List;

public class Queue<T> {
    private LinkedList<T> list = new LinkedList<>();
    Node<T> front = null, rear = null;

    public Node<T> add(T data) {
        Node<T> newNode = list.add(data);
        if (front == null)
            front = rear = newNode;
        else {
            rear = newNode;
        }
        return newNode;
    }

    public T remove() {
        if (isEmpty()) {
            front = rear = null;
            return null;
        }
        T data = front.data;
        front = list.isEmpty() ? null : list.removeHead().next;
        return data;
    }

    public boolean isEmpty() {
        return list.getSize() == 0;
    }

    public T peek() {
        if (isEmpty())
            return null;
        return front.data;

    }

    public void display() {
        list.display();
    }
}
