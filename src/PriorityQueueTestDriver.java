// Use this driver for the testing the correctness of your priority queue implementation
// You can change the add, remove sequence to test for various scenarios.
public class PriorityQueueTestDriver {
    public static void main(String[] args) {
	PriorityQueue<String> pq = new PriorityQueue<String>(5);
    Node<String> n1 = new Node<>(4,"A");
    Node<String> n2 = new Node<>(10,"B");
    Node<String> n3 = new Node<>(3, "C");
    Node<String> n4 = new Node<>(5, "E");
    Node<String> n5 = new Node<>(2, "F");
	pq.enqueue(n1);
	pq.enqueue(n2);
	pq.enqueue(n3);
	pq.enqueue(n4);
	pq.enqueue(n5);
	
	//pq.display();
	int size = pq.size();
    pq.display();
	for (int i=0; i<size; i++) {
            Node<String> n = (Node<String>) pq.dequeue();
            n.show();
            System.out.println(pq.currentSize());
	}
    pq.display();
    System.out.println(pq.currentSize());
    }
}
