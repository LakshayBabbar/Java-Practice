import List.LinkedList;
import java.util.Scanner;

public class linkedListPlayground {
    public static void main(String args[]) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        Scanner input = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("\n***********LINKED-LIST-PLAYGROUND***********\n");
            System.out.println("1. Add Element at Last");
            System.out.println("2. Add Element at Head");
            System.out.println("3. Add Element by index");
            System.out.println("4. Delete Element at Last");
            System.out.println("5. Delete Element at Head");
            System.out.println("6. Delete Element by Value: ");
            System.out.println("7. Delete Element by index: ");
            System.out.println("8. Find Element with index");
            System.out.println("9. Verify if element exists");
            System.out.println("10. Reverse the list");
            System.out.println("11. Reverse the List using Stack");
            System.out.println("12. Exit");

            System.out.print("\nChoose an Option: ");
            int choice = input.nextInt(), data = 0, index = -1;

            if (choice == 1 || choice == 2 || choice == 3 || choice == 6 || choice == 9) {
                System.out.print("Enter the data: ");
                data = input.nextInt();
            }
            if (choice == 3 || choice == 7 || choice == 8) {
                System.out.print("Enter the index: ");
                index = input.nextInt();
            }

            switch (choice) {
                case 1: {
                    list.add(data);
                    break;
                }
                case 2: {
                    list.addHead(data);
                    break;
                }
                case 3: {
                    list.addAt(data, index);
                    break;
                }
                case 4: {
                    list.remove();
                    break;
                }
                case 5: {
                    list.removeHead();
                    break;
                }
                case 6: {
                    list.remove(data);
                    break;
                }
                case 7: {
                    list.removeAt(index);
                    break;
                }
                case 8: {
                    System.out.println("Element at index " + index + ": " +list.elementAt(index));
                    break;
                }
                case 9: {
                    String isFound = list.contains(data) ? "Found" : "Not Found";
                    System.out.println("Element " + isFound);
                    break;
                }
                case 10: {
                    list.reverse();
                    break;
                }
                case 11: {
                    list.reverseUsingStack();
                    break;
                }
                case 12: {
                    loop = false;
                    break;
                }
                default: {
                    System.out.println("Invalid Option");
                    break;
                }
            }
            System.out.print("\n\nLinked-List: ");
            list.display();
            System.out.println("Size: " + list.getSize());
        }
        input.close();
    }
}