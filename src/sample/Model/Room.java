package sample.Model;

import java.sql.Statement;
import java.util.ArrayList;

public class Room {
    private int RoomNumber, wardNumber , RoomId,capacity,quantity;

    public int getRoomNumber() {
        return RoomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        RoomNumber = roomNumber;
    }

    public int getWardNumber() {
        return wardNumber;
    }

    public void setWardNumber(int wardNumber) {
        this.wardNumber = wardNumber;
    }

    public int getRoomId() {
        return RoomId;
    }

    public void setRoomId(int roomId) {
        RoomId = roomId;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }



}
