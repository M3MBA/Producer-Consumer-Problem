
public class PriorityQueue<V> implements QueueInterface<V>{

    private NodeBase<V>[] queue;
    private int capacity, currentSize;
	
    //TODO Complete the Priority Queue implementation
    // You may create other member variables/ methods if required.
    public PriorityQueue(int capacity) {    
        this.capacity = capacity;
        queue = new Node[capacity];
        currentSize = 0;
    }

    public int size() {
        return this.currentSize; 
    }

    public boolean isEmpty() {
        return (this.currentSize == 0);
    }
	
    public boolean isFull() {
        return (this.currentSize >= this.capacity);
    }

    public void enqueue(Node<V> node) {
        if (this.isFull())
            return;
        else
            this.queue[this.currentSize++] = node;
    }

    // In case of priority queue, the dequeue() should 
    // always remove the element with minimum priority value
    public NodeBase<V> dequeue() {
        if (this.isEmpty())
            return null;
        else
        {
            int min = this.queue[0].getPriority();int ind = 0;
            for (int i = 0;i < currentSize ; i++)
                if (this.queue[i].getPriority() < min)
                {
                    min = this.queue[i].getPriority();
                    ind = i;
                }
            Node<V> t;
            for (int i = ind; i < (currentSize - 1); i++)
            {
                t = (Node<V>) this.queue[i];
                this.queue[i] = this.queue[i+1];
                this.queue[i+1] = (NodeBase<V>) t;
            }
            currentSize--;
            return this.queue[currentSize];
        }
    }

    public void display () {
	    if (this.isEmpty()) {
            System.out.println("Queue is empty");
	    }
	    for(int i=0; i<currentSize; i++) {
            System.out.println(this.queue[i].getValue() + " " + this.queue[i].getPriority());
	    }
    }

}

