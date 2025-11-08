public class SoldOutState implements State{
    GumballMachine gumballMachine;

    public SoldOutState(GumballMachine gumballMachine){
        this.gumballMachine = gumballMachine;
    }

    public void insertQuarter(){
        System.out.println("fuck off!");
    }

    public void ejectQuarter(){
        System.out.println("fuck off!");
    }

    public void turnCrank(){
        System.out.println("fuck off!");
    }

    public void dispense(){
        System.out.println("fuck off!");
    }
}