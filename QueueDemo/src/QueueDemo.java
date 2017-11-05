import java.util.PriorityQueue;
import java.util.Queue;

public class QueueDemo {

	public static void main(String[] args) {
		// in a queue the first element added--the one on the bottom--is the one that is first taken care of
		// on stacks, it is the opposite: elements on the bottom are taken care last
		// Queue is a parent interface that cannot be instantiated, just like List
		
		Queue<String> queue = new PriorityQueue<>();
		
		queue.offer("Apples"); // works like add but is better for queues with defined capacity
		queue.add("Pears");
		queue.add("Bananas");
		queue.add("Oranges");
		queue.add("Cherries");
		System.out.println("queue: " + queue);
		queue.remove(); // removes the head of the queue: Apples
		System.out.println("queue: " + queue);
		System.out.println("peek: " + queue.peek()); // returns the element with highest priority
		
		queue.poll(); // also removes the head
		System.out.println("queue: " + queue);

	}

}
