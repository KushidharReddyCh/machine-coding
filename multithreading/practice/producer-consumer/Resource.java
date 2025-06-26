class Resource{
    int count;
    synchronized void consume(){
        while(count < 0){
            try{
                wait();
            }catch (Exception e){
                //
            }
        }
        this.count --;
        notifyAll();
    }

    synchronized void produce(){
        this.count++;
        notifyAll();
    }
}