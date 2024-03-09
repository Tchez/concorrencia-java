package src;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MovieTheater movieTheater = new MovieTheater();
        movieTheater.addRoom(9, 9);
        ReservationSystem reservationSystem = new ReservationSystem(movieTheater);

        System.out.println("Iniciando reservas concorrentes do assento A5...");

        List<Thread> threads = new ArrayList<>();
        final String targetSeat = "A5";

        for (int i = 0; i < 15; i++) {
            final String threadName = "Reservador-" + i;
            Thread thread = new Thread(new ReservationTask(reservationSystem, 0, targetSeat), threadName);
            threads.add(thread);
            thread.start();
        }

        threads.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Interrompido enquanto esperava as threads de reserva terminarem.");
            }
        });

        System.out.println("Todas as tentativas de reserva foram concluídas.");
    }
}
