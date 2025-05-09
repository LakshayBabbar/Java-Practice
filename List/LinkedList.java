package List;

public class LinkedList extends Node {
    Node head = null, tail = null;
    public int size = 0;

    Boolean isListEmpty() {
        return head == null;
    }

    public void addAtHead(int data) {
        Node newNode = new Node(data);
        if (isListEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    public void add(int data) {
        Node newNode = new Node(data);
        if (isListEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public void deleteAtHead() {
        if (isListEmpty())
            return;

        head = head.next;
        size--;

        if (head == null)
            tail = null;
    }

    public void delete() {
        if (isListEmpty())
            return;

        if (head == tail) {
            head = tail = null;
        } else {
            Node temp = head;
            while (temp.next != tail) {
                temp = temp.next;
            }
            temp.next = null;
            tail = temp;
        }
        size--;
    }

    public void delete(int element) {
        if (isListEmpty()) {
            System.out.println("List is empty!");
            return;
        }

        if (head.data == element) {
            deleteAtHead();
            return;
        }

        Node temp = head;
        while (temp.next != null && temp.next.data != element) {
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

    public void display() {
        if (isListEmpty()) {
            System.out.println("List is empty!");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data);
            if (temp.next != null)
                System.out.print(" -> ");
            temp = temp.next;
        }
        System.out.println();
    }
}
