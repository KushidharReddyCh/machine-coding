import java.util.List;

public class User{
    private int userID;
    private long contactNumber;
    private String driversLicenseNumber;
    private String userAddress;
    private List<Order> ordersList;

    public User(int userID, long contactNumber, String driversLicenseNumber, String userAddress, List<Order> ordersList) {
        this.userID = userID;
        this.contactNumber = contactNumber;
        this.driversLicenseNumber = driversLicenseNumber;
        this.userAddress = userAddress;
        this.ordersList = ordersList;
    }


    public int getUserID() {
        return userID;
    }

    public long getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(long contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getDriversLicenseNumber() {
        return driversLicenseNumber;
    }

    public void setDriversLicenseNumber(String driversLicenseNumber) {
        this.driversLicenseNumber = driversLicenseNumber;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public List<Order> getOrdersList() {
        return ordersList;
    }

    public void setOrdersList(List<Order> ordersList) {
        this.ordersList = ordersList;
    }


}