package List;

import ArrayList.Stack;

public class LinkedList<T> {
    private Node<T> head = null, tail = null;
    private int size = 0;

    public boolean isEmpty() {
        return head == null;
    }

    public Node<T> add(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
        return newNode;
    }

    public Node<T> addHead(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
        return newNode;
    }

    public Node<T> addAt(T data, int index) {
        Node<T> newNode = new Node<>(data), temp = head;
        if (index == 0) {
            return addHead(data);
        } else if (index == size) {
            return add(data);
        } else if (index < 0 || index >= size) {
            System.out.println("Invalid Index.");
            return null;
        }
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;

        size++;
        return newNode;
    }

    public Node<T> remove() {
        if (isEmpty())
            return null;
        Node<T> deletedNode = null;
        if (head == tail) {
            deletedNode = head;
            head = tail = null;
        } else {
            Node<T> temp = head;
            while (temp.next != tail) {
                temp = temp.next;
            }
            deletedNode = temp.next;
            temp.next = null;
            tail = temp;
        }
        size--;
        return deletedNode;
    }

    public Node<T> removeHead() {
        if (isEmpty())
            return null;
        Node<T> temp = head;
        head = head.next;
        size--;

        if (head == null)
            tail = null;
        return temp;
    }

    public Node<T> remove(T element) {
        if (isEmpty()) {
            System.out.println("List is empty!");
            return null;
        } else if (head.data.equals(element)) {
            return removeHead();
        } else if (tail.data.equals(element)) {
            return remove();
        }

        Node<T> temp = head;
        while (temp.next != null && !temp.next.data.equals(element)) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Element not found!");
            return null;
        }
        Node<T> deletedNode = temp.next;
        temp.next = temp.next.next;
        size--;
        return deletedNode;
    }

    public Node<T> removeAt(int index) {
        if (isEmpty()) {
            return null;
        } else if (index == 0) {
            return removeHead();
        } else if (index == size - 1) {
            return remove();
        }
        Node<T> temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        Node<T> deletedNode = temp.next;
        temp.next = temp.next.next;
        size--;
        return deletedNode;
    }

    public T elementAt(int idx) {
        if (idx >= size || idx < 0) {
            System.out.println("Invalid index");
            return null;
        }
        if (isEmpty())
            return null;

        Node<T> temp = head;
        for (int i = 0; i < idx; i++) {
            temp = temp.next;
        }
        return temp.data;
    }

    public boolean contains(T data) {
        if (isEmpty())
            return false;
        Node<T> temp = head;
        while (temp != null && temp.next != null) {
            temp = temp.next;
            if (temp.data == data)
                return true;
        }
        return false;
    }

    public void reverse() {
        Node<T> prev = null, curr = tail = head, next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public void reverseUsingStack() {
        Stack<Node<T>> stack = new Stack<>();
        Node<T> temp = head;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        if (stack.isEmpty())
            return;
        head = stack.pop();
        temp = head;
        while (!stack.isEmpty()) {
            temp.next = stack.pop();
            temp = temp.next;
        }
        temp.next = null;
    }

    public Node<T> midPoint() {
        Node<T> slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public int getSize() {
        return size;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("List is empty!");
            return;
        }
        Node<T> temp = head;
        while (temp != null) {
            System.out.print(temp.data);
            if (temp.next != null)
                System.out.print(" -> ");
            temp = temp.next;
        }
        System.out.println();
    }

    // To make a cyclic list only for testing
    public void createCycle() {
        if (tail != null && head != null)
            tail.next = midPoint();
    }

    // Floyd’s Tortoise and Hare algorithm
    public Boolean checkCycle() {
        Node<T> slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow)
                return true;
        }
        return false;
    }

    // Floyd’s Tortoise and Hare algorithm
    public void recoverList() {
        Node<T> slow = head, fast = head;
        boolean hasCycle = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                hasCycle = true;
                break;
            }
        }
        if (hasCycle) {
            slow = head;
            Node<T> prev = null;
            while (slow != fast) {
                prev = fast;
                slow = slow.next;
                fast = fast.next;
            }
            prev.next = null;
        }
    }
}
