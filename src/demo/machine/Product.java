package demo.machine;


public class Product {

    private String name;
    private double price;
    private int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }


    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }


    public void reduceQuantity() {
        if (quantity > 0) {
            quantity--;
        }
    }


    public boolean isInStock() {
        return quantity > 0;
    }

    @Override
    public String toString() {
        return name + " costs " + price + " (Available: " + quantity + ")";
    }
}
