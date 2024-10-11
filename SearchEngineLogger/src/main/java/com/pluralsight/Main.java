package com.pluralsight;

import java.util.Scanner;

public class Main {
    private static final String dataStorage = "data.txt";
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Choose option from: ");
        System.out.println("a. Launching the application");
        System.out.println("b. Searching for a term");
        System.out.println("c. Exiting the application");
        System.out.println("Enter a search term (X to exit): ");
        String userInput = scanner.nextLine();

        while(!userInput.equalsIgnoreCase("X")){
            
        }
    }
}