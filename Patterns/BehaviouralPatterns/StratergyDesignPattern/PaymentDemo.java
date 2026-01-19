public class PaymentDemo {

    public static void main(String[] args) {
        PaymentStatergy creditCardStatergy = new CreditCardStatergy();
        PaymentStatergy UPIStatergy = new UPIStatergy();
        // process payment with credit card
        PaymentProcessor paymentProcessor = new PaymentProcessor(creditCardStatergy);

        paymentProcessor.processPayment();

        // process payment with UPI
        paymentProcessor.setPaymentStatergy(UPIStatergy);
        paymentProcessor.processPayment();
    }
}