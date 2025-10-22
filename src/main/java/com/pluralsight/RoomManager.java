package com.pluralsight;

import java.util.ArrayList;

public class RoomManager {
    private ArrayList<Room> rooms = new ArrayList<>();
    private ArrayList<Room> checkedOutRoom = new ArrayList<>();

    // constructor to create 5 rooms
    public RoomManager() {
        for (int i = 0; i < 10; i++) {
            double price = (i % 2 == 0) ? 139 : 124; //5 kings and 5 double
            rooms.add(new Room(i, price));
        }
    }

    //Print all rooms
    public ArrayList<Room> getAllRooms() {
        return rooms;
    }

    //print all checkedout rooms
    public ArrayList<Room> getCheckedInRooms() {
        return checkedOutRoom;
    }

    public void checkInRoom(int roomNumber) {
        for (int i = 0; i < rooms.size(); i++) {
            Room room = rooms.get(i);
            if (room.getRoomNumber() == roomNumber) {
                room.checkIn();
                checkedOutRoom.add(room);
                rooms.remove(i);
            }
        }
    }


}
