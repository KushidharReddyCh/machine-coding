abstract class Beverage{
    // Beverage is an abstract class with the 2 methods getDescription and cost
    String description = "Unknown Beverage";

    public String getDescription(){ // getDescription is alreafy implemented for us, but we need to implement cost() in the subclasses.
        return description;
    }

    public abstract double cost();
}

class Espresso extends Beverage{
    public Espresso(){
        description = "Espresso";
    }
    public double cost(){
        return 1.99;
    }
}

class HouseBlend extends Beverage{
    public HouseBlend(){
        description = "House Blend Coffee";
    }

    public double cost(){
        return 0.89;
    }
}

class Mocha extends CondimentDecorator{
    public Mocha(Beverage beverage){
        this.beverage = beverage;
    }

    public String getDescription(){
        return beverage.getDescription() + ", Mocha";
    }

    public double cost(){
        return beverage.cost() + .20;
    }
}
class Whip extends CondimentDecorator{
    public Whip(Beverage beverage){
        this.beverage = beverage;
    }

    public String getDescription(){
        return beverage.getDescription() + ", Whip";
    }

    public double cost(){
        return beverage.cost() + 1.20;
    }
}
class Soy extends CondimentDecorator{
    public Soy(Beverage beverage){
        this.beverage = beverage;
    }

    public String getDescription(){
        return beverage.getDescription() + ", Soy";
    }

    public double cost(){
        return beverage.cost() + 3.20;
    }
}

public class Decorator{
    public static void main(String args[]){
        Beverage beverage = new Espresso();
        System.out.println(beverage.getDescription() + " $ " + beverage.cost());
        Beverage beverage2 = new HouseBlend();
        beverage2 = new Mocha(beverage2);
        beverage2 = new Whip(beverage2);
        beverage2 = new Whip(beverage2);
        beverage2 = new Soy(beverage2);
        System.out.println(beverage2.getDescription() + " $ " + beverage2.cost());
    }
}