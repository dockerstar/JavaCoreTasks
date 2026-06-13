package school.sorokin.javacore.Thread;

public class Counter {
    static int value = 0;

    static void increment() {
        value++;
        System.out.print(value + " ");
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(()-> {
            for (int i=0;i<1000;i++) {
                increment();
            }
        });

        Thread thread2 = new Thread(()-> {
            for (int i=0;i<1000;i++) {
                increment();
            }
        });

        thread1.start();
        thread2.start();
    }
}
