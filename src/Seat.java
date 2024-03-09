package src;

public class Seat {
    private String row;
    private int number;
    private boolean isEmpty;

    public Seat(String row, int number) {
        this.row = row;
        this.number = number;
        this.isEmpty = false;
    }

    public String getPosition() {
        return row + number;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }
}
