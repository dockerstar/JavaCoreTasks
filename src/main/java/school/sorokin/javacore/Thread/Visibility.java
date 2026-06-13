package school.sorokin.javacore.Thread;

public class Visibility {
    static boolean running = true;

    public static void main(String[] args) {
        Thread worker = new Thread(() -> {
            while (running) {
                // Пустой цикл, ждем, пока running станет false
            }
            System.out.println("Worker stopped!");
        });

        worker.start();

        // Главный поток остановит worker через 1 секунду
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        running = false; // Может быть не видно в worker потоке без синхронизации
        System.out.println("Main thread set running = false");
    }
}
