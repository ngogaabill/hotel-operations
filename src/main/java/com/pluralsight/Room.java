package com.pluralsight;

public class Room {
    private int roomNumber;
    private boolean isDirty = false;
    private boolean isOccupied = false;
    private double price;

    public Room(int roomNumber,double price) {
    this.roomNumber = roomNumber;
    this.price = price;
    }

    public int getRoomNumber() {
        return roomNumber;
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
        System.out.println("You have successfully checked in!");
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
    @Override
    public String toString() {
        return "Room #" + roomNumber + " | Price: $" + price + " per night ";
    }

}
