package demo.machine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VendingMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<Product> products = new ArrayList<>();
        products.add(new Product("Chips", 5.00,10));
        products.add(new Product("Soda", 10.00,15));
        products.add(new Product("Chocolate", 20.75,20));
        products.add(new Product("Water", 50.00,30));


        Customer customer = new Customer("You", 0.0);

        int choice;
        do {
            System.out.println("\n------ Vending Machine Menu ------");
            System.out.println("1. Display Products");
            System.out.println("2. Add Money");
            System.out.println("3. Select and Purchase Product");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    //display available prodcuts
                    System.out.println("\n--- Available Products ---");
                    for (int i = 0; i < products.size(); i++) {
                        System.out.println((i + 1) + ". " + products.get(i));
                    }
                    break;

                case 2:
                    //add amount
                    System.out.print("\nEnter amount to add : ");
                    double amount = scanner.nextDouble();
                    if(amount > 0 ){
                        customer.addCoins(new Coin(amount));
                        System.out.println("Added " + amount + " to balance.");
                    } else {
                        System.out.println("Invalid coin amount. Please enter valid amount");
                    }
                    break;

                case 3:
                    //purchase the product
                    System.out.println("\n--- Select Product ---");
                    for (int i = 0; i < products.size(); i++) {
                        System.out.println((i + 1) + ". " + products.get(i));
                    }
                    System.out.print("Enter the number of the product you want to purchase: ");
                    int productNumber = scanner.nextInt();
                    if (productNumber > 0 && productNumber <= products.size()) {
                        Product selectedProduct = products.get(productNumber - 1);

                        if(selectedProduct.isInStock()) {
                            customer.buyProduct(selectedProduct);
                            selectedProduct.reduceQuantity();
                        }
                        else {
                            System.out.println("Sorry, " + selectedProduct.getName() + " is out of stock.");
                        }
                    }

                    else {
                        System.out.println("Invalid product number.");
                    }
                    break;

                case 4:
                    //check balance
                    System.out.println("\n--- Customer Info ---");
                    System.out.println(customer);
                    System.out.println("Purchased Products: " + customer.getPurchasedProducts());
                    break;

                case 5:
                    //exit
                    System.out.println("Thank you for using the vending machine!");
                    break;

                default:
                    System.out.println("Invalid option. Please choose a valid menu option.");
            }
        } while (choice != 5);

        scanner.close();
    }

}
