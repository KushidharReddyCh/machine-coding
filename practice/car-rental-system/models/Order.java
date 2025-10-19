import enums.OrderStatus;

import java.util.HashSet;
import java.util.List;

public class Order {
    private long orderID;
    private long carID;
    private long userID;
    private long paymentID;
    private double billedAmount;
    private int startDate;
    private int endDate;



    private OrderStatus orderStatus;

    public Order(long orderID, long carID, long userID, double billedAmount, int startDate, int endDate) {
        this.orderID = orderID;
        this.carID = carID;
        this.userID = userID;
        this.billedAmount = billedAmount;
        this.startDate = startDate;
        this.endDate = endDate;
        this.orderStatus = OrderStatus.ORDER_INITIATED;
    }
    //    private PaymentStatus paymentStatus;

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public long getOrderID() {
        return orderID;
    }

    public long getCarID() {
        return carID;
    }

    public void setCarID(long carID) {
        this.carID = carID;
    }

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public long getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(long paymentID) {
        this.paymentID = paymentID;
    }

    public double getBilledAmount() {
        return billedAmount;
    }

    public void setBilledAmount(double billedAmount) {
        this.billedAmount = billedAmount;
    }
    public int getStartDate() {
        return startDate;
    }

    public void setStartDate(int startDate) {
        this.startDate = startDate;
    }

    public int getEndDate() {
        return endDate;
    }

    public void setEndDate(int endDate) {
        this.endDate = endDate;
    }
}