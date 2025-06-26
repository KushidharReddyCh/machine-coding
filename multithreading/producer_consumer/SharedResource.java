public class SharedResource {
    boolean isItemPresent = false;

    public synchronized void addItem(){
        isItemPresent = true;
        System.out.println("Producer thread calling the notifyAll method");
        notifyAll(); // notifies threads waiting on this object's monitor
    }

    public synchronized void consumeItem(){
        System.out.println("Consumer theread inside condumeItem method");
        if(!isItemPresent){
            try {
                System.out.println("Consumer thread is waiting");
                wait(); // release all the monitor lock; tells the thread to wait on this object's monitor
            } catch (Exception e) {
                // exception handling goes here
            }
        }
        System.out.println("Consumer thread is consuming the item");
        isItemPresent = false;
    }

}
