/**
 * Main class to demonstrate producer-consumer pattern
 */
public class ProducerConsumerDemo {
    public static void main(String[] args) {
        BoundedBuffer buffer = new BoundedBuffer(5);

        Thread producer = new Thread(new Producer(buffer, 10));
        Thread consumer = new Thread(new Consumer(buffer, 10));

        producer.start();
        consumer.start();

        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Main thread interrupted");
        }

        System.out.println("Final buffer size: " + buffer.size());
    }
}