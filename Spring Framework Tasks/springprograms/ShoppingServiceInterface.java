package springprograms;

public interface ShoppingServiceInterface {
    void addToCart(String item);
    void makePayment(double amount);
    void placeOrder();
}
