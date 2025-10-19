import java.time.LocalDateTime;

abstract class TrafficControlStrategy {

    boolean isEmergency;
    LocalDateTime emergencyStartTimeInMinutes;
    TrafficController trafficController;
    EmergencyHandler emergencyHandler;
//    LocalDateTime now = LocalDateTime.now();
//    int minute = now.getMinute();



    abstract boolean startSystem(List<TrafficLight> trafficLightList);

    public boolean stopSystem(List<TrafficLight> trafficLightList){
        for(TrafficLight trafficLight : trafficLightList){
            trafficLight.reset();
        }
    }

    abstract void handleEmergency(List<TrafficLight> trafficLightList, int emergencyTimeoutTimeInMinutes);

}