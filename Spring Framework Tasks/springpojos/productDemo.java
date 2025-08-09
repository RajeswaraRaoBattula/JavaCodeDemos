package springpojos;

public class productDemo {
    private String name;
    private double price;

    public productDemo(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public void showDetails() {
        System.out.println("Product Name: " + name);
        System.out.println("Price: " + price);
    }
}
