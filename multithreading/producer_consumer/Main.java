public class Main {
    public static void main(String args[]){
        SharedResource2 sharedResource = new SharedResource2();
        Thread producer = new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
                // exception handling goes here
            }
            sharedResource.addItem();
        }) ;
        Thread consumer = new Thread(() -> {
            sharedResource.consumeItem();
        });

        producer.start();
        consumer.start(); 
    }
}
