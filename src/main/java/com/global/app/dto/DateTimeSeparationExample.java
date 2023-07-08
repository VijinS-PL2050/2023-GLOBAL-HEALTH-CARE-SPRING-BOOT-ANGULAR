package com.global.app.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeSeparationExample {
    public static void main(String[] args) {
        LocalDateTime dateTime = LocalDateTime.now(); // Replace with your LocalDateTime object

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm a");

        String formattedDate = dateTime.format(dateFormatter);
        String formattedTime = dateTime.format(timeFormatter);

        System.out.println("Formatted Date: " + formattedDate);
        System.out.println("Formatted Time: " + formattedTime);
    }
}
