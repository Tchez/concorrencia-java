package src;

public class ReservationSystem {
    private MovieTheater movieTheater;

    public ReservationSystem(MovieTheater movieTheater) {
        this.movieTheater = movieTheater;
    }

    public void makeReservation(int roomIndex, String position) {
        try {
            Room room = movieTheater.getRooms().get(roomIndex);
            synchronized (room) {
                if (room.isSeatEmpty(position)) {
                    room.occupySeat(position);
                    System.out.println("Seat " + position + " has been reserved.");
                } else {
                    System.out.println("Seat " + position + " is already taken.");
                }
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Wrong room index!" + e);
        }
    }

    public void cancelReservation(int roomIndex, String position) {
        try {
            Room room = movieTheater.getRooms().get(roomIndex);
            synchronized (room) {
                if (!room.isSeatEmpty(position)) {
                    room.freeSeat(position);
                    System.out.println("Seat " + position + " has been canceled.");
                } else {
                    System.out.println("Seat " + position + " is already empty.");
                }
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Wrong room index!" + e);
        }
    }

    public String getSeatState(int roomIndex, String position) {
        try {
            Room room = movieTheater.getRooms().get(roomIndex);

            synchronized (room) {
                if (room.isSeatEmpty(position)) {
                    return "Seat " + position + " is empty.";
                } else {
                    return "Seat " + position + " is taken.";
                }
            }
        } catch (IndexOutOfBoundsException e) {
            return "Wrong room index!" + e;
        }
    }

    public void printSeatState(int roomIndex, String position) {
        System.out.println(getSeatState(roomIndex, position));
    }
}
