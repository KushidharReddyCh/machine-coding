import java.util.List;

public class OrderController {

    private long orderIDGenerator;
    private List<Order> orderList;

    public Order createOrder(long carID, long userID, double billedAmount, int startDate, int endDate){
        Order order = new Order(orderIDGenerator++, carID, userID, billedAmount, startDate, endDate);
        this.orderList.add(order);
        return order;
    }

}