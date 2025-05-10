package List;

import java.util.Stack;

public class LinkedList<T> {
    public Node<T> head = null, tail = null;
    public int size = 0;

    boolean isListEmpty() {
        return head == null;
    }

    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (isListEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public void addAtHead(T data) {
        Node<T> newNode = new Node<>(data);
        if (isListEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    public void delete() {
        if (isListEmpty())
            return;

        if (head == tail) {
            head = tail = null;
        } else {
            Node<T> temp = head;
            while (temp.next != tail) {
                temp = temp.next;
            }
            temp.next = null;
            tail = temp;
        }
        size--;
    }

    public void deleteAtHead() {
        if (isListEmpty())
            return;

        head = head.next;
        size--;

        if (head == null)
            tail = null;
    }

    public void delete(T element) {
        if (isListEmpty()) {
            System.out.println("List is empty!");
            return;
        }

        if (head.data.equals(element)) {
            deleteAtHead();
            return;
        }

        Node<T> temp = head;
        while (temp.next != null && !temp.next.data.equals(element)) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Element not found!");
            return;
        }

        temp.next = temp.next.next;
        if (temp.next == null)
            tail = temp;
        size--;
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

    public void display() {
        if (isListEmpty()) {
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
