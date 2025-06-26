/**
 * Producer thread that generates items
 */
class Producer implements Runnable {
    private final BoundedBuffer buffer;
    private final int itemCount;

    public Producer(BoundedBuffer buffer, int itemCount) {
        this.buffer = buffer;
        this.itemCount = itemCount;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= itemCount; i++) {
                buffer.put(i);
                Thread.sleep((int)(Math.random() * 100)); // Random delay
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Producer interrupted");
        }
    }
}