package decorator;

public class SugarDecorator extends CoffeeDecorator {

    public SugarDecorator(Coffee decoratorCoffee){
        super(decoratorCoffee);
    }

    @Override
    public String getDescription(){
        return decoratedCoffee.getDescription() + "+ sugar added";
    }

    @Override
    public double getCost(){
        return decoratedCoffee.getCost() + 1000;
    }
}
