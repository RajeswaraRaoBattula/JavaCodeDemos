package mymockitodemos;

public class OrderService {

    private PaymentService paymentService;

    // Constructor injection
    public OrderService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void placeOrder() {
        // Some order logic
        paymentService.processPayment();
    }
}
