// package multithreading.experiments;

class SharedResource3{
    private int counter = 0;

    public synchronized void increment(){
        System.out.println("incrementing the counter");
        try{
            Thread.sleep(1000);
        }catch(Exception e){
            //
        }
        counter++;
        System.out.println("incremented the counter to " + counter);
    }

    public synchronized void decrement(){
        System.out.println("decrementing the counter");
        counter--;
        System.out.println("decremented the counter to " + counter);
    }
}

public class Main {
    public static void main(String[] args) {
        SharedResource3 resource = new SharedResource3();
        Thread thread1 = new Thread(() -> {
            try{
                resource.increment();
            }catch(Exception e){
                //
            }
        });

        Thread thread2 = new Thread(() -> {
            try{
                resource.decrement();
            }catch(Exception e){
                // 
            }
        });
        System.out.println("starting the threads");
        
        
        thread1.start();
        thread2.start();
        System.out.println("threads started");
        // try{
        //     thread1.join();
        //     thread2.join();
        // }catch(Exception e){
        //     //
        // }
        // System.out.println("threads joined");
    }
}
