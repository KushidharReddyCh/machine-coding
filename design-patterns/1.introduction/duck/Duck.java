public abstract class Duck{
    FlyBehaviour flyBehaviour;
    QuackBehaviour quackBehaviour;

    public Duck(){

    }
    public void 


    public void swim(){
        System.out.println(" this is swimm");
    }

    public vois shit(){
        System.out.println("this is shit");
    }


    public void performQuack(){
        quackBehaviour.quack();
    }

    public void performFly(){
        flyBehaviour.fly();
    }

}