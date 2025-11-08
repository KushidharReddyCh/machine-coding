import strategy.Duck;
import strategy.SlowFlying;
import strategy.SpeedFlying;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Duck duck = new Duck(new SlowFlying());
        duck.fly();
        duck.setFlyBehaviour(new SpeedFlying());
        duck.fly();
    }
}