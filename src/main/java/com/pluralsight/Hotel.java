package com.pluralsight;

import java.util.Scanner;

public class Hotel {
    private String name;
    private int nuberOfSuites;
    private int numberOfRooms;
    private int bookedSuites;
    private int bookedBasicRooms;
    static Scanner scannner = new Scanner(System.in);

    public Hotel(String name, int bookedBasicRooms, int bookedSuites, int numberOfRooms, int nuberOfSuites) {
        this.name = name;
        this.bookedBasicRooms = bookedBasicRooms;
        this.bookedSuites = bookedSuites;
        this.numberOfRooms = numberOfRooms;
        this.nuberOfSuites = nuberOfSuites;
    }

    public Hotel(String name, int nuberOfSuites, int numberOfRooms) {
        this.name = name;
        this.nuberOfSuites = nuberOfSuites;
        this.numberOfRooms = numberOfRooms;
    }

    public boolean bookRoom(int numberOfRooms, boolean isSuites) {
        System.out.println("Enter number of rooms to book");
        int roomToBook = scannner.nextInt();
        return true;
    }

}
