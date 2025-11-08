public PlainCoffee implements Coffee{

    String description;
    double cost;

    public PlainCoffee(){
        this.description = "coffee";
        this.cost = 10;
    }


    public String getDescription(){
        return this.description;
    }


    public double getCost(){
        return this.cost;
    }
}