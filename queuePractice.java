import List.Queue;

public class queuePractice {
    public static void main(String args[]) {
        Queue<Integer> queue = new Queue<>();
        queue.add(10);
        queue.add(20);
        queue.remove();
        queue.remove();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.add(40);
        queue.add(50);
    
        System.out.print("Queue: ");
        queue.display();
        System.out.println("Peek: "+queue.peek());
    }
}
