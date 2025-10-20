package com.pluralsight;

import org.w3c.dom.ls.LSOutput;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("-----Welcome to our hotel:------");
        System.out.println("Please Enter your name");
        String customerName = scanner.nextLine().trim();
        System.out.printf("%s, Please Enter How many days your stay is:", customerName);
        int days = scanner.nextInt();
        System.out.println("Do you want king or double bed?");
        scanner.nextLine();
        String bedSize = scanner.nextLine();

        Reservation reservation = new Reservation();
        reservation.setRoomType(bedSize);
        reservation.setNumberOfNights(days);
        LocalDate dayOfWeek = LocalDate.now();
        DayOfWeek day = dayOfWeek.getDayOfWeek();
        System.out.println(day);
        boolean isWeekend = (day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY);
        reservation.setIsWeekend(isWeekend);


        System.out.println("Your total: " + reservation.getPrice());

    }
}