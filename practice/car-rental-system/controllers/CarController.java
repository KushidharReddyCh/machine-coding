import java.util.ArrayList;
import enums.CarStatus;

public class CarController {
    private long carIDGenerator;
    private ArrayList<Car> carList;


    public CarController() {
        this.carIDGenerator = 1;
        this.carList = new ArrayList<>();
    }
    public Car getCarByID(long carID){
        for(Car car : carList){
            if (car.getCarID() == carID) {
                return car;
            }
        }
        return null;
    }

    public Car createCar(String modelNumber, String licenseNumber){
        long carID = carIDGenerator++; // WARNING: NOT THREADSAFE
        Car car = new Car(carID, modelNumber, licenseNumber);
        return car;
    }

    public ArrayList<Car> getAvailableCars(int startDate, int endDate, String model, double minPrice, double maxPrice){
        ArrayList<Car> filteredCars = new ArrayList<>();
        // filter the cars
        for(Car car : this.carList){
            CarStatus carStatus = car.getCarStatus();
            boolean carAvailability = car.checkAvailability(startDate, endDate);
            double carPrice = car.getPricePerDayInRupees();
            String carModel = car.getModelNumber();
            if(
                    carStatus == CarStatus.AVAILABLE &&
                    carModel.equals(model) && carAvailability &&
                    carPrice >= minPrice && carPrice <= maxPrice
            ){
                filteredCars.add(car);
            }
        }
        return filteredCars;
    }

}
