package com.pluralsight;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        String userInput = "10/10/2024";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate date = LocalDate.parse(userInput, formatter);
        DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String formatedDate = date.format(outputFormat);
        System.out.println(formatedDate);


        LocalDate today = LocalDate.now();
        System.out.println(today);

        LocalDate dates = LocalDate.now();
        System.out.println(dates.getMonth() + " " + dates.getDayOfMonth() + ", " + dates.getYear());

        LocalDate differentDate = LocalDate.now();
        LocalTime currentTime = LocalTime.now();
        System.out.println(differentDate.getDayOfWeek() + ", " + differentDate.getMonth() + " " + differentDate.getDayOfMonth() + ", " + differentDate.getYear() + " " + currentTime.getHour() + ":" + currentTime.getMinute());

        String todaysDate = "10/10/2024";
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate date2 = LocalDate.parse(todaysDate, formatter2);
        DateTimeFormatter outputFormat2 = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formatedDate2 = date2.format(outputFormat2);
        System.out.println(currentTime.getHour() + ":" + currentTime.getMinute() + " on " + formatedDate2);
    }
}