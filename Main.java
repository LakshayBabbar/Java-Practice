import List.LinkedList;

public class Main {
    public static void main(String args[]) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(10);
        list.add(15);
        list.add(20);
        list.add(25);
        list.add(40);
        list.add(30);
        list.add(35);
        list.addAtHead(5);
        list.delete(40);
        list.deleteAtHead();
        list.delete();

        // Make this list Cyclic
        list.tail.next = list.midPoint();

        if (list.checkCycle()) {
            System.out.println("Cycle Detected!");
            list.recoverList();
            System.out.print("Cycle Recovered: ");
            list.display();
        } else {
            System.out.print("List: ");
            list.display();
            list.reverse();
            System.out.print("Reversed List: ");
            list.display();
        }
        System.out.println("List Size: " + list.size);
    }
}