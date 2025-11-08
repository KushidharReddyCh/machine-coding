public class GumballMachine {


    State  soldOutState;
    State noQuarterState;
    State hasQuarterState;
    State soldState;

    State state = soldState;


    int count = 0;

    public GumballMachine(int numberOfGumballs){
        soldOutState = new SoldOutState(this);
        noQuarterState = new NoQuarterState(this);
        hasQuarterState = new HasQuarterState(this);
        soldState = new SoldState(this);

        this.count = numberOfGumballs;
        if(numberOfGumballs > 0){
            state = noQuarterState;
        }else {
            state = soldOutState;
        }
    }
    void releaseBall(){
        System.out.println("a gumball comes rolling the slot..");
        if(count > 0){
            count = count - 1;
        }
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }


    public void setState(State state){
        this.state = state;
    }

    public void insertQuarter(){
        state.insertQuarter();
    }

    public void ejectQuarter(){
        state.ejectQuarter();
    }
    public void turnCrank(){
        state.turnCrank();
    }
    public void dispense(){
        state.dispense();
    }
    public State getSoldOutState() {
        return soldOutState;
    }

    public State getNoQuarterState() {
        return noQuarterState;
    }

    public State getHasQuarterState() {
        return hasQuarterState;
    }

    public State getSoldState() {
        return soldState;
    }

}