package com.pluralsight;

import java.io.FileWriter;

public class Main {
    public static void main(String[] args) {
        try{
            FileWriter fileReader = new FileWriter("newFile.csv");

            fileReader.write("Skills: \n");
            fileReader.write("HTML, CSS, JavaScript");
            fileReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}