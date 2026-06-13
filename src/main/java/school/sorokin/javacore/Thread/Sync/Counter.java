package school.sorokin.javacore.Thread.Sync;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class Counter {
    private static int value = 0;
    private static AtomicInteger atomicInteger = new AtomicInteger(0);
    private static final Object lock = new Object();
    private static ReentrantLock reentrantLock = new ReentrantLock();

    public static void increment() {
        reentrantLock.lock();
        try {
            value++;
        } finally {
            reentrantLock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                increment();
            }
        };

        Thread[] threads = new Thread[10];

        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(task);
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("итог - " + value);
    }
}
