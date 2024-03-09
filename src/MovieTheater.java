package src;

import java.util.LinkedList;

public class MovieTheater {
    LinkedList<Room> rooms = new LinkedList<>();

    public void addRoom(int rows, int seatsPerRow) {
        rooms.add(new Room(rows, seatsPerRow));
    }

    public void printRooms() {
        for (int i = 0; i < rooms.size(); i++) {
            System.out.println("Room " + i + ":");
            rooms.get(i).printSeats();
            System.out.println("\n");
        }
    }

    public LinkedList<Room> getRooms() {
        return rooms;
    }

    public void printSeats(int roomNumber) {
        rooms.get(roomNumber).printSeats();
    }

    public LinkedList<Seat> getSeats(int roomNumber) {
        return rooms.get(roomNumber).seats;
    }
}
