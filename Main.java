import List.LinkedList;

public class Main {
    public static void main(String args[]) {
        LinkedList list = new LinkedList();
        list.add(10);
        list.add(15);
        list.add(20);
        list.add(25);
        list.add(40);
        list.add(30);
        list.add(35);
        list.addAtHead(5);
        list.delete(40);
        list.display();
        System.out.println("Size of List: " + list.size);
    }
}
