import ArrayList.Stack;
import Exceptions.ElementNotFoundException;
import java.util.EmptyStackException;
import java.util.Scanner;

public class stackPlayground {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        boolean loop = true;

        System.out.println("\n--------------STACK-PLAYGROUND--------------");
        while (loop) {
            try {
                System.out.println("1. Push data");
                System.out.println("2. Pop data");
                System.out.println("3. Stack Peek");
                System.out.println("4. Find element by index");
                System.out.println("5. Check if the element exists in the stack");
                System.out.println("6. Exit");

                System.out.print("\nChoose an option: ");
                int choice = input.nextInt();
                switch (choice) {
                    case 1:
                        System.out.print("Enter the data: ");
                        stack.push(input.nextInt());
                        break;
                    case 2:
                        stack.pop();
                        break;
                    case 3:
                        System.out.println("Peek: " + stack.peek());
                        break;
                    case 4:
                        System.out.print("Enter the index: ");
                        System.out.println(stack.elementAt(input.nextInt()));
                        break;
                    case 5:
                        System.out.print("Enter the element: ");
                        System.out.println(stack.contains(input.nextInt()));
                        break;
                    case 6:
                        loop = false;
                        break;
                    default:
                        System.out.println("Invalid Option.");
                        break;
                }
                System.out.println("\n----------STACK----------");
                stack.display();
                System.out.println("Size: " + stack.size());
                System.out.println("-------------------------");
            } catch (StackOverflowError e) {
                System.out.println("Error: " + e.getMessage());
            } catch (EmptyStackException e) {
                System.out.println("Error: Stack is empty. Cannot pop or peek.");
            } catch (ElementNotFoundException e) {
                System.out.println(e.getMessage());
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Error: Invalid Index.");
            }
        }
        input.close();
    }
}
