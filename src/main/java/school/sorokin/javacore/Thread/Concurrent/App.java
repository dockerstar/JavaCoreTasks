package school.sorokin.javacore.Thread.Concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class App {
    private static final List<Integer> integerList = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        int count = 0;

        Thread[] threads = new Thread[10];

        Runnable task = () -> {
            for (int i = 0; i<100; i++) {
                integerList.add(i);
            }
        };

        for (int i=0; i<threads.length; i++) {
            threads[i] = new Thread(task);
            threads[i].start();
        }

        for (Thread thread:threads) {
            thread.join();
        }

        System.out.println("Size: " + integerList.size());

    }
}
