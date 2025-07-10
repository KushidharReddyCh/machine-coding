import java.util.concurrent.locks.ReentrantLock;

class SharedResource{
    int x;

    public SharedResource(int x) {
        this.x = x;
    }
}

class Worker implements Runnable{

    private final ReentrantLock lock;
    private final SharedResource sharedResource;

    public Worker(ReentrantLock lock, SharedResource sharedResource){
        this.lock = lock;
        this.sharedResource = sharedResource;
    }

    @Override
    public void run(){
        for(int i = 0; i < 10; i++){
            lock.lock();
            try {
                Thread.sleep(1);
                System.out.println("Thread = " + Thread.currentThread().getName());
                sharedResource.x++;
            } catch (Exception e) {
                // exception goes here
            }finally{
                lock.unlock();
            }
        }
    }
}


public class Hakuna {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource(0);
        ReentrantLock lock = new ReentrantLock();
        Thread[] threadList = new Thread[50];
        for(int i = 0; i < 50; i++){
            threadList[i] = new Thread(new Worker(lock, sharedResource));
            threadList[i].start();
        }
        try {
            for(Thread thread: threadList){
                thread.join();
            }
        } catch (Exception e) {
        }
        System.out.println(sharedResource.x);
    }
}
