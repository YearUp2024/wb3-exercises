package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class StoreApp {
    public static ArrayList<Product> inventory = getInventory();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ListAllProduct();
        LookupProductByID();
        LookupProductByPriceRange();
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
        System.out.println("Enter a product ID: ");
        double price = scanner.nextDouble();

        boolean foundProduct = false;
        for(Product product : inventory){
            if(product.getPrice() == price){
                System.out.printf("Product ID: %d\nName: %s\nPrice: %.2f", product.getId(), product.getName(), product.getPrice());
                foundProduct = true;
                break;
            }
        }
        if(!foundProduct){
            System.out.println("Product was not found");
        }
    }

    /**
     * Add new product into product list.
     */
    public static void AddNewProduct(){}

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
