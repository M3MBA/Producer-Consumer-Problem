import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Buyer<V> extends BuyerBase<V> {
    int catalogSize;
    int num;
    public Buyer (int sleepTime, int catalogSize, Lock lock, Condition full, Condition empty, PriorityQueue<V> catalog, int iteration) {
        setSleepTime(sleepTime);
        this.catalog = catalog;
        setIteration(iteration);
        this.lock = lock;
        this.empty = empty;
        this.full = full;
        this.catalogSize = catalogSize;
    }
    public void buy() throws InterruptedException {
        this.lock.lock();
            try {
                Node<V> n;
                //this.empty.signal();
                while (this.catalog.isEmpty())
                      this.empty.await();
                if (!(this.catalog.isEmpty())) 
                {
                    n = (Node<V>) this.catalog.dequeue();
                    if (n != null) {
                    System.out.print("Consumed "); // DO NOT REMOVE (For Automated Testing)
                    n.show(); // DO NOT REMOVE (For Automated Testing)
                    }
                      // ...
                      // 
                    //val = true;
                    this.full.signalAll();
                }
            } catch (Exception e) {
                    e.printStackTrace();
            } finally {
                this.lock.unlock();
            }
    }
}
