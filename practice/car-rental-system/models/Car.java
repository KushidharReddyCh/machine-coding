import java.util.List;
import enums.CarStatus;

public class Car {
    int carID;
    String modelNumber;
    String licenseNumber;
    double pricePerDayInRupees;
    CarStatus carStatus;
    List<Integer> availableDates; // note: assuming for the time being dates are repensented as numbers 1 --> jan 1st, 32 --> feb1
    List<Integer> bookedDates;

    public Car(int carID, String modelNumber, String licenseNumber) {
        this.carID = carID;
        this.modelNumber = modelNumber;
        this.licenseNumber = licenseNumber;
    }

    public double getPricePerDayInRupees() {
        return pricePerDayInRupees;
    }

    public void setPricePerDayInRupees(double pricePerDayInRupees) {
        this.pricePerDayInRupees = pricePerDayInRupees;
    }

    public CarStatus getCarStatus() {
        return carStatus;
    }

    public void setCarStatus(CarStatus carStatus) {
        this.carStatus = carStatus;
    }

    public List<Integer> getAvailableDates() {
        return availableDates;
    }

    public void setAvailableDates(List<Integer> availableDates) {
        this.availableDates = availableDates;
    }

    public List<Integer> getBookedDates() {
        return bookedDates;
    }

    public void setBookedDates(List<Integer> bookedDates) {
        this.bookedDates = bookedDates;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    public int getCarID() {
        return carID;
    }

    public void setCarID(int carID) {
        this.carID = carID;
    }

}