import enums.OrderStatus;
import enums.PaymentStatus;

public class CarRentalSystem {

    private OrderController orderController;
    private PaymentController paymentController;
    private CarController carController;

    public CarRentalSystem(CarController carController, PaymentController paymentController, OrderController orderController){
        this.carController = carController;
        this.paymentController = paymentController;
        this.orderController = orderController;
    }

    public boolean completePayment(User user, Order order){
        Payment payment = paymentController.createPayment(order.getBilledAmount(), PaymentStatus.PAYMENT_INITIATED);
        return paymentController.completePayment(payment);
    }

    public boolean cancelBooking(Order order, int currentDay){
        // checking cancel eligibility
        if(currentDay >= order.getStartDate()){
            System.out.println("cancellation failed as the currentDay + "+ currentDay +" exceeded the booking startDate" + order.getStartDate());
            return false;
        }
        long carID = order.getCarID();
        Car car = carController.getCarByID(carID);
        boolean unBlockingStatus =  car.unblockDates(order.getStartDate(), order.getEndDate());
        if(!unBlockingStatus) return false;
        order.setOrderStatus(OrderStatus.ORDER_CANCELLED);
        Payment payment = paymentController.getPaymentById(order.getPaymentID());
        return paymentController.completeRefund(payment);
    }


    public Order bookCar(User user, int startDate, int endDate, Car car){
        boolean blockDates = car.blockDates(startDate, endDate);
        if(!blockDates) return null;
        int numberOfDaysCarBooked = endDate - startDate;
        double billedAmount = numberOfDaysCarBooked * car.getPricePerDayInRupees();
        Order order = orderController.createOrder(car.getCarID(), user.getUserID(), billedAmount, startDate, endDate);
        order.setOrderStatus(OrderStatus.ORDER_CREATED);
        return order;
    }

}