package src;

import java.util.LinkedList;

public class MovieTheater {
    private LinkedList<Room> rooms = new LinkedList<>();

    public void addRoom(int rows, int seatsPerRow) {
        rooms.add(new Room(rows, seatsPerRow));
    }

    public LinkedList<Room> getRooms() {
        return rooms;
    }
}
