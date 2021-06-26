// This class implements the Queue
public class Queue<V> implements QueueInterface<V>{

    //TODO Complete the Queue implementation
    private NodeBase<V>[] queue;
    private int capacity, currentSize, front, rear;
	
    public Queue(int capacity) {    
        this.capacity = capacity;
        queue = (Node[])new Node[this.capacity];
        this.currentSize = 0;
        this.front = 0;
        this.rear = 0;
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
        {
            return;
        }
        else
        {
            this.queue[this.currentSize++] = node;
        }
    }

    public NodeBase<V> dequeue() {
        if (this.isEmpty())
            return null;
        else
        {
            //NodeBase<V> temp = this.queue[0]; 
            Node<V> t;
            for (int i = 0; i < (currentSize - 1); i++)
            {
                t = (Node<V>)this.queue[i];
                this.queue[i] = this.queue[i+1];
                this.queue[i+1] = (NodeBase<V>)t;
            }
            currentSize--;
            return this.queue[currentSize];
        }
    }

    public void display()
    {
        for (int i = 0; i < currentSize; i++)
            System.out.println(this.queue[i].getValue());
    }

}

