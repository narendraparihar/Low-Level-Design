package StratergyDesignPattern.CreditCardStatergy
public class CreditCardStatergy implements PaymentStatergy {
    @Override
    public void processPayment() {
        System.out.println("Payment is being processed using Credit Card");
    }
}
