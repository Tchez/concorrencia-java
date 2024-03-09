package src;

public class Seat {
    private final String row;
    private final int number;
    private boolean isEmpty;

    public Seat(String row, int number) {
        this.row = row;
        this.number = number;
        this.isEmpty = true;
    }

    public String getPosition() {
        return row + number;
    }

    public synchronized boolean isEmpty() {
        return isEmpty;
    }

    public synchronized void setEmpty(boolean empty) {
        isEmpty = empty;
    }
}
