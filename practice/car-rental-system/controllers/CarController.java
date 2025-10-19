import java.util.List;
import java.util.ArrayList;

public class CarController {
    private long carIDGenerator;
    private ArrayList<Car> carList;

    public CarController() {
        this.carIDGenerator = 1;
        this.carList = new ArrayList<>();
    }

    public createCar(String modelNumber, String licenseNumber){
        long carID = carIDGenerator++; // WARNING: NOT THREADSAFE
        Car car = new Car(carID, modelNumber, licenseNumber);

    }

//    + CRUD Car
//+ getAvailableCars(StartDate,EndDate,Model,minPrice,maxPrice)
//+ bookCar(userId, StartDate, EndDate, carId) ---> OrderId
//+ cancelBooking(userId, OrderId)
//+ completePayment(userId, orderId) --> OrderId
//+ calculatePrice(StartDate, EndDate, carId) --> price

    public getAvailableCars(startDate, endDate, String model, double minPrice, maxPrice){

    }



    private List<Car> getCarList() {
        return carList;
    }

    private void setCarList(List<Car> carList) {
        this.carList = carList;
    }

    private void addCar(Car car){
        this.carList.add(car);
        return;
    }
}