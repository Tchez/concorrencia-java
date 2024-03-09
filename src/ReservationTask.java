package src;

import java.util.Random;

public class ReservationTask implements Runnable {
    private final ReservationSystem reservationSystem;
    private final int roomIndex;
    private final String seatPosition;
    private final Random random = new Random();

    public ReservationTask(ReservationSystem reservationSystem, int roomIndex, String seatPosition) {
        this.reservationSystem = reservationSystem;
        this.roomIndex = roomIndex;
        this.seatPosition = seatPosition;
    }

    @Override
    public void run() {
        // Atraso inicial aleatório para simular diferentes tempos de início de ação
        int delay = random.nextInt(500);

        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("[" + Thread.currentThread().getName() + "] was interrupted during initial delay.");
        }

        boolean reserved = reservationSystem.makeReservation(roomIndex, seatPosition);

        if (reserved) {
            System.out.println("[" + Thread.currentThread().getName() + "] Seat " + seatPosition
                    + " has been successfully reserved.");
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("[" + Thread.currentThread().getName() + "] was interrupted.");
            }
            reservationSystem.cancelReservation(roomIndex, seatPosition);
            System.out.println("[" + Thread.currentThread().getName() + "] Seat " + seatPosition
                    + " reservation has been cancelled.");
        } else {
            System.out.println("[" + Thread.currentThread().getName() + "] could not reserve seat " + seatPosition
                    + " as it was already taken.");
        }
    }
}
