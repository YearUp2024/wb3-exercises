package com.pluralsight;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter story name: ");
        String storyName = scanner.nextLine().replace(' ', '_') + ".txt";

        try{
            FileInputStream file = new FileInputStream(storyName);
            Scanner fileScanner = new Scanner(file);
            String story;
            int lineCount = 1;
            
            while(fileScanner.hasNextLine()){
                story = fileScanner.nextLine();
                System.out.println(lineCount++ + ": " + story);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

