package com.pluralsight;

import org.w3c.dom.ls.LSOutput;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        roomReservation();
        //employeePunchInOut();
    }

    private static void employeePunchInOut() {
        //Employee class
        Employee employee = new Employee("bill", 12332, "Manager", 40);
        System.out.println("Enter Punch In Time:(HH:mm)");
        String timeIn = scanner.nextLine();
        double punchInTime = convertStringToDecimal(timeIn);
        employee.punchIn(punchInTime);
        System.out.println("Enter Punch Out Time:(HH:mm)");
        String timeOut = scanner.nextLine();
        double punchOutTime = convertStringToDecimal(timeOut);
        employee.punchOut(punchOutTime);
        System.out.println("You made total of " + employee.getTotalPay());
        // employee.getTotalPay();

    }

    public static double convertStringToDecimal(String s) {
        String[] parts = s.split(":");
        int hour = Integer.parseInt(parts[0]);
        int minute = Integer.parseInt(parts[1]);
        return hour + minute / 60.0;
    }

    private static void roomReservation() {

        System.out.println("-----Welcome to our hotel:------");
        System.out.println("Please Enter your name");
        String customerName = scanner.nextLine().trim();
        System.out.printf("%s, Please Enter How many days your stay is:", customerName);
        int days = scanner.nextInt();
        System.out.println("Do you want king or double bed?");
        scanner.nextLine();
        String bedSize = scanner.nextLine();
        System.out.println("How many rooms?");
        int roomsNeeded = scanner.nextInt();

        Reservation reservation = new Reservation();
        reservation.setRoomType(bedSize);
        reservation.setNumberOfNights(days);
        LocalDate dayOfWeek = LocalDate.now();
        DayOfWeek day = dayOfWeek.getDayOfWeek();
        boolean isWeekend = (day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY);
        reservation.setIsWeekend(isWeekend);
        System.out.println("Your total: $" + reservation.getPrice());

        RoomManager roomManager = new RoomManager();
        ArrayList<Room> sortedRooms = new ArrayList<>();

        int roomCounter = 0;
        if (roomManager.getAllRooms().isEmpty()) {
            System.out.println("No Rooms are available");
        } else {
            for (Room c : roomManager.getAllRooms()) {
                if (c.getPrice() == 139 && reservation.getRoomType().equalsIgnoreCase("king")) {
                    roomCounter++;
                    sortedRooms.add(c);//to hold the ones based on the user choice
                } else if (reservation.getRoomType().equalsIgnoreCase("double") && c.getPrice() == 124) {
                    roomCounter++;
                    sortedRooms.add(c);
                }
            }
//            Hotel hotel = new Hotel(customerName, roomsNeeded, roomCounter);
//            hotel.loadBookedInventory(sortedRooms);//load inventory
        }
        System.out.printf("%d %s Rooms Available\n", roomCounter, reservation.getRoomType());
        System.out.println("Do you want to Check In Y/N:");
        scanner.nextLine();
        String input = scanner.nextLine().trim();
        /// Generate a Random room from the sorted Rooms of the same Room Type
        if (input.equalsIgnoreCase("Y")) {
            Random random = new Random();
            int randomRoom = random.nextInt(sortedRooms.size());
            Room selectedRoom = sortedRooms.get(randomRoom);
            roomManager.checkInRoom(selectedRoom.getRoomNumber());
            roomCounter--;
        } else if (input.equalsIgnoreCase("N")) {
            System.out.println("Not checked in.");
        } else {
            System.out.println("Invalid input. Please enter Y or N.");
        }
        //TESTING --Fixed bug Generates a random room based on the user choice
        System.out.println("Checked In " + roomManager.getCheckedInRooms().toString());
        System.out.printf("Remaining Rooms %d", roomCounter);

    }
}

