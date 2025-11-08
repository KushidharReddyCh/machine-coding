package strategy;

public class SlowFlying implements FlyBehaviour{

    @Override
    public void fly() {
        System.out.println("i am flying slow!!!!");
    }
}
