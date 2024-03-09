package src;

import java.util.LinkedList;

public class Room {
    LinkedList<Seat> seats = new LinkedList<>();
    private int rows;
    private int seatsPerRow;

    public Room(int rows, int seatsPerRow) {
        this.rows = rows;
        this.seatsPerRow = seatsPerRow;

        this.createSeats();
    }

    private void createSeats() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < seatsPerRow; j++) {
                seats.add(new Seat(String.valueOf((char) (i + 65)), j + 1));
            }
        }
    }

    public void printSeats() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < seatsPerRow; j++) {
                System.out.print(seats.get(i * seatsPerRow + j).getPosition() + " ");
            }
            System.out.println();
        }
    }

    public void occupySeat(String position) {
        for (Seat seat : seats) {
            if (seat.getPosition().equals(position)) {
                seat.setEmpty(false);
            }
        }
    }

    public void freeSeat(String position) {
        for (Seat seat : seats) {
            if (seat.getPosition().equals(position)) {
                seat.setEmpty(true);
            }
        }
    }

    public boolean isSeatEmpty(String position) {
        for (Seat seat : seats) {
            if (seat.getPosition().equals(position)) {
                return seat.isEmpty();
            }
        }
        return false;
    }
}
