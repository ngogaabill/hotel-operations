package com.pluralsight;

import java.util.ArrayList;

public class Room {
    private int roomNumbers;
    private boolean isDirty = false;
    private boolean isOccupied = false;
    private double price;

    public Room(int roomNumber,double price) {
    this.roomNumbers = roomNumber;
    this.price = price;
    }

    public int getRoomNumbers() {
        return roomNumbers;
    }

    public double getPrice() {
        return price;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public boolean isDirty() {
        return isDirty;
    }

    public boolean isAvailable() {
        return !isDirty && !isOccupied;
    }

    public void checkIn() {
        System.out.println("Room Checked In");
        isDirty = true;
        isOccupied = true;

    }

    public void checkOut() {
        System.out.println("Room Checked In");
        cleanroom();
        isDirty = false;
        isOccupied = false;
    }

    public void cleanroom() {
        System.out.println("Room is Being Cleaned,After check out");
        //update the room status after cleaning.
        isOccupied = false;
        isDirty = false;
    }
}
