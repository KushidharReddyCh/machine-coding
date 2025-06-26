public class Main {
    public static void main(String[] args) {
        SharedResource2 resource = new SharedResource2();

        Thread producer1 = new Thread(() -> {
            while (true) {
                resource.addItem();
                try { Thread.sleep(100); } catch (InterruptedException ignored) {}
            }
        }, "Producer-1");

        Thread producer2 = new Thread(() -> {
            while (true) {
                resource.addItem();
                try { Thread.sleep(100); } catch (InterruptedException ignored) {}
            }
        }, "Producer-2");

        Thread consumer = new Thread(() -> {
            while (true) {
                resource.consumeItem();
                try { Thread.sleep(1000); } catch (InterruptedException ignored) {}
            }
        }, "Consumer");

        // Start all
        producer1.start();
        producer2.start();

        // Delay to ensure both producers start and fill the buffer
        try {
            Thread.sleep(500);
        } catch (Exception e) {
        }
        consumer.start();
    }
}
