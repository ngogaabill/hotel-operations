package com.pluralsight;

public class Room {
    //private final int roomNumbers = 50;
    private boolean isAvailable;
    private boolean isDirty;
    private boolean isOccupied;
    private double price;

    public Room(){

    }

    public int getRoomNumbers() {
        return roomNumbers;
    }
    public double getPrice(){
        return price;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public boolean isDirty() {
        return isDirty;
    }

    public boolean isAvailable() {
        return isAvailable;
    }
}
