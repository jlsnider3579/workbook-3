
    package Com.pluralsight.store;

import java.util.ArrayList;
import java.util.Scanner;

    public class Main {
        public static void main(String[] args) {
            // Initialize the store and load inventory
            OnlineStore store = new OnlineStore();
            store.getInventory();  // Load products from CSV

            // Set up Scanner for user input
            Scanner scanner = new Scanner(System.in);
            boolean isRunning = true;

            while (isRunning) {
                // Display Home Screen
                System.out.println("\nWelcome to the Online Store!");
                System.out.println("1. Display Products");
                System.out.println("2. Display Cart");
                System.out.println("3. Exit");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();
                scanner.nextLine();  // Consume newline

                switch (choice) {
                    case 1:
                        displayProductsMenu(store, scanner);
                        break;
                    case 2:
                        store.displayCart();
                        break;
                    case 3:
                        System.out.println("Thank you for visiting the store!");
                        isRunning = false;
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                        break;
                }
            }
            scanner.close();
        }

        // Method to handle the Display Products menu
        public static void displayProductsMenu(OnlineStore store, Scanner scanner) {
            boolean inProductsMenu = true;

            while (inProductsMenu) {
                System.out.println("\nStore Inventory:");
                store.displayProducts();

                System.out.println("\nOptions:");
                System.out.println("1. Search Products");
                System.out.println("2. Add Product to Cart");
                System.out.println("3. Go Back to Home Page");
                System.out.print("Choose an option: ");
                int option = scanner.nextInt();
                scanner.nextLine();  // Consume newline

                switch (option) {
                    case 1:
                        searchProductsMenu(store, scanner);
                        break;
                    case 2:
                        System.out.print("Enter the product name to add to the cart: ");
                        String productName = scanner.nextLine();
                        ArrayList<Product> searchResult = store.searchProducts(productName, "name");
                        if (!searchResult.isEmpty()) {
                            store.addToCart(searchResult.get(0));  // Add the first found product to the cart
                        } else {
                            System.out.println("Product not found.");
                        }
                        break;
                    case 3:
                        inProductsMenu = false;
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                        break;
                }
            }
        }

        // Method to handle the search products functionality
        public static void searchProductsMenu(OnlineStore store, Scanner scanner) {
            System.out.println("\nSearch Options:");
            System.out.println("1. Search by Name");
            System.out.println("2. Search by Price");
            System.out.println("3. Search by Department");

        }
    }
