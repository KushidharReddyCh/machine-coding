class TrafficControlSystem{

    TrafficControlStrategy trafficControlStrategy;
    List<TrafficLight> trafficLightList;

    public TrafficControlSystem(List<TrafficLight> trafficLightList){
        this.trafficLightList = trafficLightList;
    }

    public TrafficControlStrategy getTrafficControlStrategy() {
        return trafficControlStrategy;
    }

    public void setTrafficControlStrategy(TrafficControlStrategy trafficControlStrategy) {
        this.trafficControlStrategy = trafficControlStrategy;
    }

    public List<TrafficLight> getTrafficLightList() {
        return trafficLightList;
    }

    public void setTrafficLightList(List<TrafficLight> trafficLightList) {
        this.trafficLightList = trafficLightList;
    }

    public boolean startSystem(){
        return trafficControlStrategy.startSystem(this.trafficLightList);
    }

    public boolean stopSystem(){
        return trafficControlStrategy.stopSystem(this.trafficLightList);
    }

    public void handleEmergency(int emergencyTimeoutTime){
        trafficControlStrategy.handleEmergency(this.trafficLightList, emergencyTimeoutTime);
    }
}