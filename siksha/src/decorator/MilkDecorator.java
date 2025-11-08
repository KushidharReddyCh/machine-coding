package decorator;

public class MilkDecorator extends CoffeeDecorator {

    public MilkDecorator(Coffee decoratedCoffee){
        super(decoratedCoffee);
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription() + "+ milk";
    }

    @Override
    public double getCost(){
        return decoratedCoffee.getCost() + 100;
    }


}
