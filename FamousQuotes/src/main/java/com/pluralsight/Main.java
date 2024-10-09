package com.pluralsight;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] quotes = {
                "The only limit to our realization of tomorrow is our doubts of today. - Franklin D. Roosevelt",
                "Do what you can, with what you have, where you are. - Theodore Roosevelt",
                "In the middle of difficulty lies opportunity. - Albert Einstein",
                "Success is not final, failure is not fatal: It is the courage to continue that counts. - Winston Churchill",
                "It always seems impossible until it’s done. - Nelson Mandela",
                "Don’t watch the clock; do what it does. Keep going. - Sam Levenson",
                "The way to get started is to quit talking and begin doing. - Walt Disney",
                "Everything you’ve ever wanted is on the other side of fear. - George Addair",
                "Success usually comes to those who are too busy to be looking for it. - Henry David Thoreau",
                "Believe you can and you're halfway there. - Theodore Roosevelt"
        };

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        while (true){
            try{
                System.out.println("Do you want a random quote: ");
                String chooseRandom = scanner.nextLine();

                if(!chooseRandom.equalsIgnoreCase("Yes")){
                    System.out.print("do you want to continue? ");
                    String userInput = scanner.nextLine();
                    if(!userInput.equalsIgnoreCase("yes")){
                        break;
                    }

                    System.out.println("Enter a number between 1 and 10: ");
                    short index = scanner.nextShort();
                    System.out.println("Quote: " + quotes[index]);
                }else{
                    int randomRange = random.nextInt(10);
                    System.out.println("Quote: " + quotes[randomRange]);
                }
            }catch (Exception e){
                System.out.println("Your number is too large or too small");
            }
        }
    }
}