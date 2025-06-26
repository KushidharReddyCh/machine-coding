import java.util.ArrayList;
import java.util.List;
public class Main {

    public static void main(String args[]) {
        Resource resource = new Resource();

       List<Thread> threadList = new ArrayList<>();

        for(int i=0; i < 10; i++){
            Thread t1 = new Thread(() -> {
                try{
                    Thread.sleep(10);
                }catch (Exception e){
                    //
                }
                resource.produce();
            });
            Thread t2 = new Thread(() -> {
                try{
                    Thread.sleep(10);
                }catch (Exception e){
                    //
                }

                resource.consume();
            });
            threadList.add(t1);
            threadList.add(t2);
            t1.start();
            t2.start();
        }

        for(Thread t: threadList){
            try{
                t.join();
            }catch (Exception e) {
                // Exception goes here
            }
        }

        System.out.println("final count = " + resource.count);
    }
}
