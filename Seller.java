import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Seller<V> extends SellerBase<V> {
	
    int catalogSize;
    int num;
    public Seller (int sleepTime, int catalogSize, Lock lock, Condition full, Condition empty, PriorityQueue<V> catalog, Queue<V> inventory) {
        setSleepTime(sleepTime);
        this.catalogSize = catalogSize;
        this.lock = lock;
        this.full = full;
        this.empty = empty;
        this.catalog = catalog;
        this.inventory = inventory;
    }
    
    public void sell() throws InterruptedException {
       this.lock.lock();
              try {
                  //this.full.signal();
                  while (this.catalog.isFull())
                      this.full.await();
                  if (!this.catalog.isFull())
                  {
                      //n = this.inventory.dequeue();
                      if (!inventory.isEmpty())
                        this.catalog.enqueue((Node<V>)inventory.dequeue());
                  //val = true;
                  this.empty.signalAll();
                  }
              } catch(Exception e) {
                      e.printStackTrace();
              } finally {
                  this.lock.unlock();
	          }		
    }
}
