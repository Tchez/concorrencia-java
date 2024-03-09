package src;

public class ReservationSystem {
    private MovieTheater movieTheater;

    public ReservationSystem(MovieTheater movieTheater) {
        this.movieTheater = movieTheater;
    }

    public boolean makeReservation(int roomIndex, String position) {
        try {
            Room room = movieTheater.getRooms().get(roomIndex);

            synchronized (room) {
                if (room.isSeatEmpty(position)) {
                    room.reserveSeat(position);
                    System.out.println(
                            "[" + Thread.currentThread().getName() + "] Seat " + position + " has been reserved.");
                    return true;
                } else {
                    System.out.println(
                            "[" + Thread.currentThread().getName() + "] Seat " + position + " is already taken.");
                    return false;
                }
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Wrong room index!" + e);
            return false;
        }
    }

    public boolean cancelReservation(int roomIndex, String position) {
        try {
            Room room = movieTheater.getRooms().get(roomIndex);

            synchronized (room) {
                if (!room.isSeatEmpty(position)) {
                    room.cancelSeatReservation(position);
                    System.out.println(
                            "[" + Thread.currentThread().getName() + "] Seat " + position + " has been canceled.");
                    return true;
                } else {
                    System.out.println(
                            "[" + Thread.currentThread().getName() + "] Seat " + position + " is already empty.");
                    return false;
                }
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Wrong room index!" + e);
            return false;
        }
    }
}
