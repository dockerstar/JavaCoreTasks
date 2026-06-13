package school.sorokin.javacore.Thread.Deadlock;

public class DeadlockLessons {
    private static Object lockA = new Object();
    private static Object lockB = new Object();

    public static void main(String[] args) {
        Thread firstThread = new Thread(() -> {
            synchronized (lockA) {
                System.out.println("захват A первым потоком");
                synchronized (lockB) {
                    System.out.println("захват B первым потоком");
                }
            }
        });

        Thread secondThread = new Thread(() -> {
            synchronized (lockA) {
                System.out.println("захват A вторым потоком");
                synchronized (lockB) {
                    System.out.println("захват B вторым потоком");
                }
            }
        });

        firstThread.start();

        secondThread.start();


    }
}
