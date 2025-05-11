import Array.Stack;
import Exceptions.ElementNotFoundException;
import java.util.EmptyStackException;

public class stackPractice {
    public static void main(String[] args) {
        Stack stack = new Stack(10);

        try {
            stack.push(10);
            stack.push(20);
            stack.push(30);
            stack.push(40);
            stack.push(50);
            stack.push(60);
            stack.push(70);
            stack.push(80);
            stack.push(90);
            stack.push(100);
            stack.pop();
            stack.pop();
            System.out.println("Stack: "+stack.toString());
            System.out.println("Size: " + stack.getSize());
            System.out.println("Peek: " + stack.peek());
            System.out.println("Element at 6th index: " + stack.elementAt(6));
            System.out.println("Element 100 contains at index: " + stack.contains(100));

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
}
