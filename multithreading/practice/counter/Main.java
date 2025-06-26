package counter;
import java.util.ArrayList;
import java.util.List;

class Count {
    private int x;

    public Count(int initialValue) {
        this.x = initialValue;
    }

    // Synchronized increment with wait/notify demo
    public synchronized void increment() {
        System.out.println("WAITING:: " + Thread.currentThread().getName() + " | State: " + Thread.currentThread().getState());
        try {
            wait(); // waits until notified
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        try {
            Thread.sleep(10); // simulate work
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        x++;
        System.out.println("RESUMED:: " + Thread.currentThread().getName() + " | State: " + Thread.currentThread().getState());
        notify(); // notify one waiting thread
    }

    public synchronized void notifyOneThread() {
        System.out.println("▶ Notifying one thread...");
        notify();
    }

    public synchronized void notifyAllThreads() {
        System.out.println("▶ Notifying all threads...");
        notifyAll();
    }

    public synchronized int getValue() {
        return x;
    }
}

public class Main {
    public static void main(String[] args) {
        Count count = new Count(0);
        List<Thread> threads = new ArrayList<>();

        // Create and start threads
        for (int i = 0; i < 6; i++) {
            Thread t1 = new Thread(() -> count.increment(), "Worker-" + (2 * i));
            Thread t2 = new Thread(() -> count.increment(), "Worker-" + (2 * i + 1));

            threads.add(t1);
            threads.add(t2);

            System.out.println("CREATED:: " + t1.getName() + " | State: " + t1.getState());

            t1.start();
            t2.start();

            // t2.interrupt();
            // t1.interrupt();

            System.out.println("STARTED:: " + t2.getName() + " | State: " + t2.getState());
        }

        // Wait a moment to let threads reach waiting state
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Print mid-execution states
        System.out.println("\n📍 MID-EXECUTION THREAD STATES:");
        for (Thread t : threads) {
            System.out.println(t.getName() + " | State: " + t.getState());
        }

        // Notify one thread to proceed
        count.notifyOneThread();

        // Wait for all threads to finish
        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        // final states
        System.out.println("\n📍 FINAL THREAD STATES:");

        for(Thread t : threads){
            System.out.println(
                t.getName() + " | State: " + t.getState()
            );
        }

        // Final count
        System.out.println("\n✅ Final count = " + count.getValue());
    }
}
