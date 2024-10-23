package demo.machine;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private String name;
    private double balance;
    private List<Product> purchasedProducts;

    public Customer(String name, double balance) {
        this.name = name;
        this.balance = balance;
        this.purchasedProducts = new ArrayList<>();
    }


    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }


    public void addCoins(Coin coin) {
        this.balance += coin.getValue();
    }


    public void buyProduct(Product product) {
        if (balance >= product.getPrice()) {
            balance -= product.getPrice();
            purchasedProducts.add(product);
            System.out.println(name + " purchased " + product.getName());
        } else {
            System.out.println(name + " does not have enough balance to buy " + product.getName());
        }
    }


    public List<Product> getPurchasedProducts() {
        return purchasedProducts;
    }


    @Override
    public String toString() {
        return name + " has a balance of $" + balance;
    }


}
