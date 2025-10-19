import java.util.HashSet;
import java.util.List;
import enums.CarStatus;

public class Car {
    long carID;
    String modelNumber;
    String licenseNumber;
    double pricePerDayInRupees;
    CarStatus carStatus;
    HashSet<Integer> availableDates; // note: assuming for the time being dates are repensented as numbers 1 --> jan 1st, 32 --> feb1
    HashSet<Integer> bookedDates;

    public Car(long carID, String modelNumber, String licenseNumber) {
        this.carID = carID;
        this.modelNumber = modelNumber;
        this.licenseNumber = licenseNumber;
    }

    public boolean checkAvailability(int startDate, int endDate){
        for(int date = startDate; date <= endDate; date++){
            if(!availableDates.contains(date)){
                return false;
            }
        }
        return true;
    }

    public boolean unblockDates(int startDate, int endDate){
        for(int date = startDate; date <= endDate; date++){
            if(bookedDates.contains(date)){
                bookedDates.remove(date);
                availableDates.add(date);
            }else{
                return false;
            }
        }
        return true;
    }

    public boolean blockDates(int startDate, int endDate){
        for(int date = startDate; date <= endDate; date++){
            if(availableDates.contains(date)){
                availableDates.remove(date);
                bookedDates.add(date);
            }else{
                return false;
            }
        }
        return true;
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

    public HashSet<Integer> getAvailableDates() {
        return availableDates;
    }

    public void setAvailableDates(HashSet<Integer> availableDates) {
        this.availableDates = availableDates;
    }

    public HashSet<Integer> getBookedDates() {
        return bookedDates;
    }

    public void setBookedDates(HashSet<Integer> bookedDates) {
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

    public long getCarID() {
        return carID;
    }
}