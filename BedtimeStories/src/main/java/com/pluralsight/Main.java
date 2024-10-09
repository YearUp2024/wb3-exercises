package com.pluralsight;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter story name: ");
        String storyName = scanner.nextLine().replace(' ', '_');

        try{
            FileInputStream story = new FileInputStream(storyName);
            Scanner fileScanner = new Scanner(story);
            String input;
            int lineCount = 1;
            while(fileScanner.hasNextLine()){
                input = fileScanner.nextLine();
                System.out.println(lineCount++ + ": " + input);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

