import java.util.concurrent.locks.ReentrantLock;

class SCounter{
    int x;

    SCounter(int x){
        this.x = x;
    }
}

public class Driver {
    
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        SCounter sc = new SCounter(0);
        Thread t1 = new Thread(() -> {
            System.out.println("inside thread t1");
            try {
                lock.lock();
                System.out.println("taken lock of t1");
                sc.x++;
            } catch (Exception e) {
                // exception goes here
            } finally{
                lock.unlock();
                System.out.println("t1 thread is finished!!");
            }

        });
        Thread t2 = new Thread(() -> {
            System.out.println("inside thread 2");
            try {
                lock.lock();
                System.out.println("taken lock of t2");
                sc.x++;
            } catch (Exception e) {
            }finally{
                lock.unlock();
                System.out.println("t2 thread is finished");
            }
        });
        
        t1.start();
        t2.start();

        try{
            t1.join();
            t2.join();
        }catch (Exception e){
            // exception goes here
        }
        System.out.println("all completeeeee!!!!");
    }
}
