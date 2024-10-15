package Com.pluralsight.store;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class OnlineStore {
    ArrayList<Product> inventory = new ArrayList<>();
    ArrayList<Product> cart = new ArrayList<>();

    // Constructor
    public OnlineStore() {
        // The constructor can initialize empty lists
        this.cart = new ArrayList<>();
        this.inventory = new ArrayList<>();
    }

    // Method to get inventory from CSV file
    public void getInventory() {
        try {
            FileReader fileReader = new FileReader("src/main/resources/products.csv");
            BufferedReader bufReader = new BufferedReader(fileReader);
            String input = bufReader.readLine();  // Skip header line
            while ((input = bufReader.readLine()) != null) {
                String[] productInfo = input.split("[|]");
                String sku = productInfo[0];
                String productName = productInfo[1];
                double price = Double.parseDouble(productInfo[2]);
                String department = productInfo[3];
                Product product = new Product(sku, productName, price, department);
                inventory.add(product);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // Display all products in the inventory
    public void displayProducts() {
        System.out.println("Store Inventory:");
        for (Product product : inventory) {
            System.out.println(product);
        }
    }

    // Search products by name, price, or department
    public ArrayList<Product> searchProducts(String query, String type) {
        ArrayList<Product> result = new ArrayList<>();
        for (Product product : inventory) {
            switch (type) {
                case "name":
                    if (product.getProductName().equalsIgnoreCase(query)) {
                        result.add(product);
                    }
                    break;
                case "price":
                    if (Double.toString(product.getPrice()).equals(query)) {
                        result.add(product);
                    }
                    break;
                case "department":
                    if (product.getDepartment().equalsIgnoreCase(query)) {
                        result.add(product);
                    }
                    break;
            }
        }
        return result;
    }

    // Add a product to the cart
    public void addToCart(Product product) {
        cart.add(product);
        System.out.println(product.getProductName() + " has been added to your cart.");
    }

    // Remove a product from the cart
    public void removeFromCart(String productName) {
        for (Product product : cart) {
            if (product.getProductName().equalsIgnoreCase(productName)) {
                cart.remove(product);
                System.out.println(productName + " has been removed from your cart.");
                return;
            }
        }
        System.out.println("Product not found in cart.");
    }

    // Display the cart with total price
    public void displayCart() {
        double total = 0;
        System.out.println("Your Cart:");
        for (Product product : cart) {
            System.out.println(product);
            total += product.getPrice();
        }
        System.out.println("Total: $" + total);
    }
}
