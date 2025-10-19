import enums.PaymentStatus;

import java.util.List;

public class PaymentController {
    private long paymentIDGenerator;
    private List<Payment> paymentList;

    public Payment createPayment(double amount, PaymentStatus paymentStatus){
        Payment payment = new Payment(paymentIDGenerator++, amount, paymentStatus);
        return payment;
    }

    public Payment getPaymentById(long paymentID){
        for(Payment payment : paymentList){
            if (payment.getPaymentID() == paymentID) {
                return payment;
            }
        }
        return null;
    }

    public boolean completePayment(Payment payment){
        if(payment.getPaymentStatus() != PaymentStatus.PAYMENT_INITIATED ||
            payment.getPaymentStatus() != PaymentStatus.PAYMENT_FAILED
        ){
            System.out.println("payment in invalid state");
            return false;
        }
        int paymentChance = (int)Math.random()*100;
        if(paymentChance >= 30){
            payment.setPaymentStatus(PaymentStatus.PAYMENT_SUCCESS);
            return true;
        }
        payment.setPaymentStatus(PaymentStatus.PAYMENT_FAILED);
        return false;
    }


    public boolean completeRefund(Payment payment){
        if(payment.getPaymentStatus() != PaymentStatus.PAYMENT_SUCCESS ||
            payment.getPaymentStatus() != PaymentStatus.REFUND_FAILED ||
                payment.getPaymentStatus() != PaymentStatus.PAYMENT_INITIATED
        ){
            System.out.println("payment in invalid state");
            return false;
        }
        int paymentChance = (int)Math.random()*100;
        if(paymentChance >= 10){
            payment.setPaymentStatus(PaymentStatus.REFUND_COMPLETED);
            return true;
        }
        payment.setPaymentStatus(PaymentStatus.REFUND_FAILED);
        return false;
    }
}