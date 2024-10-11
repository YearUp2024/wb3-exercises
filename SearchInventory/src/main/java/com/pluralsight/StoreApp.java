package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class StoreApp {
    public static ArrayList<Product> inventory = getInventory();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("What do you want to do?");
        System.out.println("1- List all products");
        System.out.println("2- Lookup a product by its id");
        System.out.println("3- Find all products within a price range");
        System.out.println("4- Add a new product");
        System.out.println("5- Quit the application");
        System.out.print("Enter command:");

        int input = scanner.nextInt();
        switch(input){
            case 1:
                ListAllProduct();
                break;
            case 2:
                LookupProductByID();
                break;
            case 3:
                LookupProductByPriceRange();
                break;
            case 4:
                AddNewProduct();
                break;
            case 5:
                break;
        }
    }

    /**
     * List all product in the list
     */
    public static void ListAllProduct(){
        System.out.println("We carry the following inventory: ");
        for (int i = 0; i < inventory.size(); i++) {
            Product p = inventory.get(i);
            System.out.printf(" id: %d %s - Price: $%.2f\n",
                    p.getId(), p.getName(), p.getPrice());
        }
    }

    /**
     * Display Product detail by ID
     */
    public static void LookupProductByID(){
        System.out.println("Enter a product ID: ");
        short id = scanner.nextShort();

        boolean foundProduct = false;
        for(Product product : inventory){
            if(product.getId() == id){
                System.out.printf("Product ID: %d\nName: %s\nPrice: %.2f\n", product.getId(), product.getName(), product.getPrice());
                foundProduct = true;
                break;
            }
        }
        if(!foundProduct){
            System.out.println("Product was not found");
        }
    }

    /**
     * Lookup product by price range
     */
    public static void LookupProductByPriceRange(){
        System.out.println("Enter the minimum price: ");
        double minPrice = scanner.nextDouble();

        System.out.println("Enter the maximum price: ");
        double maxPrice = scanner.nextDouble();

        boolean foundProduct = false;
        for (Product i : inventory){
            if (i.getPrice() <= maxPrice && i.getPrice() >= minPrice){
                System.out.printf("id: %d %s - Price: $%.2f\n",i.getId(), i.getName(), i.getPrice());
                foundProduct = true;
            }
        }
        if(!foundProduct){
            System.out.println("No Products available at the price range!");
        }
    }

    /**
     * Add new product into product list.
     */
    public static void AddNewProduct(){
        System.out.println("Welcome to Add New Product Application");

        System.out.print("Please Enter an ID Number: ");
        int productId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Please Enter the Product name: ");
        String productName = scanner.nextLine();

        System.out.print("Please Enter the Price: ");
        float productPrice = scanner.nextFloat();

        Product p = new Product(productId, productName, productPrice);
        inventory.add(p);

        System.out.println("Product added successfully!");
    }

    public static ArrayList<Product> getInventory() {
        ArrayList<Product> inventory = new ArrayList<Product>();

        try {
            FileReader fr = new FileReader("inventory.csv");
            BufferedReader be = new BufferedReader(fr);

            String input;
            while((input = be.readLine()) != null){
                String[] tokens = input.split(Pattern.quote("|"));
                int productID = Integer.parseInt(tokens[0]);
                String produceName = tokens[1];
                float productPrice = Float.parseFloat(tokens[2]);
                Product p = new Product(productID, produceName, productPrice);
                inventory.add(p);
                System.out.println(input);
            }
            be.close();

        }catch(Exception e){
            System.out.println("Error");
        }
        return inventory;
    }
}
