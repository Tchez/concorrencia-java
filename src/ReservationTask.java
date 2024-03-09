package src;

public class ReservationTask implements Runnable {
    private final ReservationSystem reservationSystem;
    private final int roomIndex;
    private final String seatPosition;
    private final boolean cancelAfterReservation;

    public ReservationTask(
            ReservationSystem reservationSystem, int roomIndex, String seatPosition, boolean cancelAfterReservation) {
        this.reservationSystem = reservationSystem;
        this.roomIndex = roomIndex;
        this.seatPosition = seatPosition;
        this.cancelAfterReservation = cancelAfterReservation;
    }

    @Override
    public void run() {
        reservationSystem.makeReservation(roomIndex, seatPosition);

        if (cancelAfterReservation) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("[" + Thread.currentThread().getName() + "] interrompida durante o cancelamento.");
            }
            reservationSystem.cancelReservation(roomIndex, seatPosition);
        }
    }
}
