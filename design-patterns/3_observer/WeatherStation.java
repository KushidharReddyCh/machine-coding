//package observer;

import java.util.ArrayList;

public class WeatherStation{
    public static void main(String args[]){
        WeatherData weatherData = new WeatherData();
        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);
        weatherData.setMeasurements(70, 10, 34);
    }
}

interface Subject{
    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObservers();


    float getTemp();
    float getHumidity();
    float getPressure();
}

interface Observer{
    // pass state instead of all the params
    public void update();
}

interface DisplayElement{
    public void display();
}

class WeatherData implements Subject{
    private ArrayList<Observer> observers;
    private float temp;
    private float humidity;
    private float pressure;

    public WeatherData(){
        observers = new ArrayList<>();
    }

    public void registerObserver(Observer o){
        observers.add(o);
    }

    public void removeObserver(Observer o){
        int idx = observers.indexOf(o);
        if(idx >= 0){
            observers.remove(idx);
        }
    }

    public void notifyObservers(){
        for(Observer observer : observers){ // is explicit type casting needed? learn about java type casting here...
//            Observer observer = (Observer) o;
            observer.update();
        }
    }
    public void measurementsChanged(){
        notifyObservers();
    }
    public void setMeasurements(float temp, float humidity, float pressure){
        this.temp = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }
    public float getTemp(){
        return this.temp;
    }
    public float getHumidity(){
        return this.humidity;
    }
    public float getPressure(){
        return this.pressure;
    }
}

class CurrentConditionsDisplay implements  Observer, DisplayElement{

    private float temp;
    private float humidity;
    private Subject weatherData; // but why? why do we need to store ? may be in future we may need to remove

    public CurrentConditionsDisplay(Subject weatherData){
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update(){
        this.temp = weatherData.getTemp();
        this.humidity = weatherData.getHumidity();
        display();
    }

    @Override
    public void display(){
        System.out.println("current conditions = " + temp + " F degrees & humidity = " + humidity);
    }
}

