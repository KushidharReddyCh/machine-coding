// package multithreading.producer_consumer_buffer;
import java.util.LinkedList;
import java.util.Queue;

public class SharedResource2 {
    Queue<Integer> queue = new LinkedList<Integer>();
    final int MAX_SIZE = 1;
    
    public synchronized void addItem(){
        while(queue.size() == MAX_SIZE){
            try {
                System.out.println("producer is waiting!!!");
                wait();
            } catch (Exception e) {
                System.out.println("exception occured = " + e.getMessage());
            }
        }
        queue.add(1);
        System.out.println("added the item QS=");
        notify();
    }

    public synchronized void consumeItem(){
        System.out.println("Trying to consumer the item......");
        while(queue.isEmpty()){
            try {
                System.out.println("consumer is waiting.....");
                wait();
            } catch (Exception e) {
                System.out.println("exception occured = " + e.getMessage());
            }
        }
        queue.remove();
        notify();
        System.out.println("consumed the item QS= ");        
    }
}
