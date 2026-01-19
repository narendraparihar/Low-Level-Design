public class PaymentProcessor {
    PaymentStatergy paymentStatergy;

    PaymentProcessor(PaymentStatergy paymentStatergy) {
        this.paymentStatergy = paymentStatergy;
    }

    public void processPayment() {
        paymentStatergy.processPayment();
    }

    public void setPaymentStatergy(PaymentStatergy paymentStatergy) {
        this.paymentStatergy = paymentStatergy;
    }
}
