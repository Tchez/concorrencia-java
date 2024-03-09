package src;

public class Main {
    public static void main(String[] args) {
        MovieTheater movieTheater = new MovieTheater();
        movieTheater.addRoom(9, 9);
        movieTheater.addRoom(8, 8);
        movieTheater.printRooms();
    }
}