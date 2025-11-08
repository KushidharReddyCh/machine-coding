public class NoQuarterState implements State{
    GumballMachine gumballMachine;

    public NoQuarterState(GumballMachine gumballMachine){
        this.gumballMachine = gumballMachine;
    }

    public void insertQuarter(){
        System.out.println("you inserted a quarter");
        gumballMachine.setState(gumballMachine.getHasQuarterState());
    }

    public void ejectQuarter(){
        System.out.println("you havent inserted a quarter");
    }

    public void turnCrank(){
        System.out.println("you turned, but there is no quarter");
    }

    public void dispense(){
        System.out.println("you need to pay firstt");
    }
}