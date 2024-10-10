package com.pluralsight;


import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
//        String userInput = "10/10/2024";
//        Scanner scanner = new Scanner(System.in);
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
//        LocalDate date = LocalDate.parse(userInput, formatter);
//        DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
//        String formatedDate = date.format(outputFormat);
//        System.out.println(formatedDate);
//
//        LocalDate today = LocalDate.now();
//        System.out.println(today);
//
//        LocalDate dates = LocalDate.now();
//        System.out.println(dates.getMonth() + " " + dates.getDayOfMonth() + ", " + dates.getYear());
//
//        LocalDate differentDate = LocalDate.now();
//        LocalTime currentTime = LocalTime.now();
//        System.out.println(differentDate.getDayOfWeek() + ", " + differentDate.getMonth() + " " + differentDate.getDayOfMonth() + ", " + differentDate.getYear() + " " + currentTime.getHour() + ":" + currentTime.getMinute());
//
//        String todaysDate = "10/10/2024";
//        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("MM/dd/yyyy");
//        LocalDate date2 = LocalDate.parse(todaysDate, formatter2);
//        DateTimeFormatter outputFormat2 = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//        String formatedDate2 = date2.format(outputFormat2);
//        System.out.println(currentTime.getHour() + ":" + currentTime.getMinute() + " on " + formatedDate2);

        System.out.println("Enter a date formatting example: (yyyy-MM-dd): ");
        String formatting = scanner.nextLine();

        System.out.println("Enter the date: ");
        String userDate = scanner.nextLine();

        String date = formattingDate(formatting, userDate);
        System.out.println(date);
    }

    public static String formattingDate(String formatting, String userDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatting);
        LocalDate date = LocalDate.parse(userDate, formatter);
        DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern(formatting);
        return date.format(outputFormat);
    }
}