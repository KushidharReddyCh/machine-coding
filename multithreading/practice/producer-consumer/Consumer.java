/**
 * Consumer thread that processes items
 */
class Consumer implements Runnable {
    private final BoundedBuffer buffer;
    private final int itemCount;

    public Consumer(BoundedBuffer buffer, int itemCount) {
        this.buffer = buffer;
        this.itemCount = itemCount;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < itemCount; i++) {
                buffer.take();
                Thread.sleep((int)(Math.random() * 100)); // Random delay
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Consumer interrupted");
        }
    }
}