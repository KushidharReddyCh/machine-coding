package strategy;

public class Duck {

    FlyBehaviour flyBehaviour;

    public Duck(FlyBehaviour flyBehaviour){
        this.flyBehaviour = flyBehaviour;
    }
    public FlyBehaviour getFlyBehaviour() {
        return flyBehaviour;
    }

    public void setFlyBehaviour(FlyBehaviour flyBehaviour) {
        this.flyBehaviour = flyBehaviour;
    }

    public void fly(){
        this.flyBehaviour.fly();
    }



}
