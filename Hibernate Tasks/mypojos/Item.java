package mypojos;

import javax.persistence.*;

@Entity
@Table(name="wipro_Items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private double price;

    public Item() {}

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }

    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setPrice(double price) { this.price = price; }

    @Override
    public String toString() {
        return "Item [id=" + id + ", name=" + name + ", price=" + price + "]";
    }
}

