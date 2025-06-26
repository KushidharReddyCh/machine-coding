import java.util.LinkedList;
import java.util.Queue;

/**
 * Thread-safe bounded buffer for producer-consumer pattern
 */
public class BoundedBuffer {
    private final Queue<Integer> queue;
    private final int capacity;

    public BoundedBuffer(int capacity) {
        this.capacity = capacity;
        this.queue = new LinkedList<>();
    }

    public synchronized void put(int item) throws InterruptedException {
        while (queue.size() >= capacity) {
            wait(); // Wait until space is available
        }
        queue.offer(item);
        System.out.println("Produced: " + item + " | Buffer size: " + queue.size());
        notifyAll(); // Notify waiting consumers
    }

    public synchronized int take() throws InterruptedException{
        while (queue.isEmpty()) {
            wait(); // Wait until item is available
        }
        int item = queue.poll();
        System.out.println("Consumed: " + item + " | Buffer size: " + queue.size());
        notifyAll(); // Notify waiting producers
        return item;
    }

    public synchronized int size() {
        return queue.size();
    }
}
