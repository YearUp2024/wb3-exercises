package com.pluralsight;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter story name: ");
        String storyName = scanner.nextLine().replace(' ', '_') + ".txt";

        String[] possibleStories = {"goldilocks", "hansel_and_gretel", "mary_has_a_little_lamb"};
        boolean storyFound = false;
        for(String story : possibleStories){
            if(story.equalsIgnoreCase(storyName)){
                storyFound = true;
                break;
            }
        }

        if(!storyFound){
            char firstChar = storyName.charAt(0);
            for(String story : possibleStories){
                if(story.charAt(0) == firstChar){
                    System.out.println("Did you mean: " + story.replace('_', ' ') + ": ");
                    String lookingFor = scanner.nextLine();

                    try{
                        FileInputStream file = new FileInputStream(story+".txt");
                        Scanner fileScanner = new Scanner(file);
                        String userStory;
                        int lineCount = 1;

                        while(fileScanner.hasNextLine()){
                            userStory = fileScanner.nextLine();
                            System.out.println(lineCount++ + ": " + userStory);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println("Story not found.");
            return;
        }

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