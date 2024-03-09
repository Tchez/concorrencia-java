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
                    room.reserveSeat(position);
                    System.out.println(
                            "[" + Thread.currentThread().getName() + "] Seat " + position + " has been reserved.");
                } else {
                    System.out.println(
                            "[" + Thread.currentThread().getName() + "] Seat " + position + " is already taken.");
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
                    room.cancelSeatReservation(position);
                    System.out.println(
                            "[" + Thread.currentThread().getName() + "] Seat " + position + " has been canceled.");
                } else {
                    System.out.println(
                            "[" + Thread.currentThread().getName() + "] Seat " + position + " is already empty.");
                }
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Wrong room index!" + e);
        }
    }
}
