package com.pluralsight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {

    @Test
    void checkIn() {
        //Arrange
        Room room = new Room(1,200);
        //Act
        room.checkIn();
        //Assert
        assertTrue(room.isOccupied());
        assertTrue(room.isDirty());
        assertFalse(room.isAvailable());


    }

    @Test
    void checkOut() {
        //Arrange
        Room room = new Room(1,200);
        //Act
        room.checkOut();
        //Assert
        assertFalse(room.isOccupied());
        assertFalse(room.isDirty());
        assertTrue(room.isAvailable());
    }

    @Test
    void cleanroom() {
        Room room = new Room(3,139);
        room.checkIn();
        //Act
        room.cleanroom();
        //Assert
        assertFalse(room.isDirty());
        assertTrue(room.isAvailable());
        assertFalse(room.isOccupied());
    }
}