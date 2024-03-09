package src;

public class Main {
    public static void main(String[] args) {
        MovieTheater movieTheater = new MovieTheater();
        movieTheater.addRoom(9, 9);
        movieTheater.addRoom(8, 8);

        ReservationSystem reservationSystem = new ReservationSystem(movieTheater);

        reservationSystem.printSeatState(0, "A1");
        reservationSystem.makeReservation(0, "A1");
        reservationSystem.printSeatState(0, "A1");
        reservationSystem.cancelReservation(0, "A1");
        reservationSystem.printSeatState(0, "A1");
    }
}