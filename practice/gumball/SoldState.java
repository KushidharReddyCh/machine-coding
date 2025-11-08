public class SoldState implements State{
    GumballMachine gumballMachine;

    public SoldState(GumballMachine gumballMachine){
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
        gumballMachine.releaseBall();
        if(gumballMachine.getCount() > 0){
            gumballMachine.setState(gumballMachine.getNoQuarterState());
        }else{
            System.out.println("warehosue full");
            gumballMachine.setState(gumballMachine.getSoldOutState());
        }
    }
}