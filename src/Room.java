package src;

import java.util.LinkedList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Room {
    private final LinkedList<Seat> seats = new LinkedList<>();
    private final int rows;
    private final int seatsPerRow;
    private final Lock seatLock = new ReentrantLock();

    public Room(int rows, int seatsPerRow) {
        this.rows = rows;
        this.seatsPerRow = seatsPerRow;
        createSeats();
    }

    private void createSeats() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < seatsPerRow; j++) {
                seats.add(new Seat(String.valueOf((char) (i + 65)), j + 1));
            }
        }
    }

    public void reserveSeat(String position) {
        Seat seat = getSeatByPosition(position);

        if (seat != null && seat.isEmpty()) {
            seat.setEmpty(false);
        }
    }

    public void cancelSeatReservation(String position) {
        Seat seat = getSeatByPosition(position);

        if (seat != null && !seat.isEmpty()) {
            seat.setEmpty(true);
        }
    }

    public boolean isSeatEmpty(String position) {
        Seat seat = getSeatByPosition(position);

        return seat != null && seat.isEmpty();
    }

    public Seat getSeatByPosition(String position) {
        seatLock.lock();
        try {
            return seats.stream()
                    .filter(seat -> seat.getPosition().equals(position))
                    .findFirst()
                    .orElse(null);
        } finally {
            seatLock.unlock();
        }
    }
}
