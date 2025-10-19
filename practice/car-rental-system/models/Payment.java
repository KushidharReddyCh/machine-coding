import enums.PaymentStatus;

public class Payment {
    private long paymentID;


    private double amount;
    private PaymentStatus paymentStatus;

    public Payment(long paymentID, double amount, PaymentStatus paymentStatus) {
        this.paymentID = paymentID;
        this.amount = amount;
        this.paymentStatus = paymentStatus;
    }

    public long getPaymentID(){
        return this.paymentID;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

}