package com.pluralsight;

public class Reservation {
    private String roomType;
    private double price;
    private int numberOfNights;
    private boolean isWeekend;
    private double total;

    public Reservation() {

    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public double getPrice() {
        if (!isWeekend()) {
            if (getRoomType().contains("king")) {
                price = 139.00 * getNumberOfNights();
            } else if (getRoomType().contains("double")) {
                price = 124.00 * getNumberOfNights();
            }
        } else {
            if (getRoomType().contains("king")) {
                price = 139.0 * getNumberOfNights();
            } else if (getRoomType().contains("double")) {
                price = 124.0 * getNumberOfNights();
            }
            price += (price / 0.1);
        }
        return price;
    }

    public void setNumberOfNights(int numberOfNights) {
        this.numberOfNights = numberOfNights;
    }

    public int getNumberOfNights() {
        return numberOfNights;
    }

    public boolean isWeekend() {
        return isWeekend;
    }

    public void setIsWeekend(boolean isWeekend) {
        this.isWeekend = isWeekend;
    }

    public double getReservationTotal() {
        return total;
    }
}
