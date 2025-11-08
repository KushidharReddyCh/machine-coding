package decorator;

public class PlainCoffee implements Coffee {

    String description;
    double cost;

    public PlainCoffee(){
        this.description = "coffee";
        this.cost = 10;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public double getCost() {
        return this.cost;
    }
}
