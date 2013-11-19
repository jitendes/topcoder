import java.util.LinkedList;
import java.util.Queue;

public class BlockingQueue<T> {
	private Queue<T> queue = new LinkedList<T>();
	private int capacity=10;

	public BlockingQueue(int capacity) {
		if (capacity<=0) throw new IllegalArgumentException(""+capacity);
		this.queue=new LinkedList<T>();
		this.capacity = capacity;
	}
	
	//Both methods lock the same monitor, so add and remove cannot be executed concurrently
	public synchronized void add(T item) throws InterruptedException {
		while (isFull()) {
			wait();
		}
		// Notify all the threads that are waiting
		if (isEmpty()) {
			notifyAll();
		}
		this.queue.add(item);
	}

	public synchronized Object remove() throws InterruptedException {
		while (isEmpty()) {
			wait();
		}
		if (isFull()) {
			notifyAll();
		}
		return this.queue.remove(0);
	} 
  
	private boolean isEmpty() {
        return queue.size() == 0;
    }
    private boolean isFull() {
        return queue.size() == this.capacity;
    }
}
