package school.sorokin.javacore.Thread.App;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.random.RandomGenerator;

public class DataProcessor {
    private static final ExecutorService executorService = Executors.newFixedThreadPool(10);
    private static final AtomicInteger atomicInteger = new AtomicInteger(1);
    private static final Map<String, Integer> map = new LinkedHashMap<>();
    private static final RandomGenerator random = new Random();
    private static final Object lock = new Object();
    private static final Integer countTasks = 5;
    private static final AtomicInteger submittedCountTasks = new AtomicInteger(0);
    private static final List<Future<Integer>> listFuture = new ArrayList<>();

    public static void shutdown() {
        executorService.shutdown();
        try {
            boolean isTerminated = executorService.awaitTermination(10000, TimeUnit.MILLISECONDS);
            if (!isTerminated) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            throw new RuntimeException(e);
        }
    }


    public static CompletableFuture<Integer> taskSubmission(List<Integer> integerList) {
        CalculateSumTask calculateSumTask = new CalculateSumTask(integerList, "task" + atomicInteger.get());
        CompletableFuture<Integer> taskFuture = CompletableFuture.supplyAsync(
                calculateSumTask::call,
                executorService
        );
        taskFuture.thenAccept(res-> {
           synchronized (lock) {
               map.put(calculateSumTask.getTaskName(), res);
           }
        });
        atomicInteger.incrementAndGet();// счетчик тасков
        submittedCountTasks.incrementAndGet();//счетчик отправки тасков

        return taskFuture;
    }

    //разница между отправленными тасками и выполненнными тасками
    public static void countActiveCurrentTasks() {
        System.out.println("Осталось " +(submittedCountTasks.get()-CalculateSumTask.completedCountTasks.get()) + " задач в пуле потоков");
    }

    public static Optional<Integer> resultTask(String nameTask) {
        synchronized (lock) {
            return Optional.ofNullable(map.get(nameTask));
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        for (int i =0; i<countTasks; i++) {
            countActiveCurrentTasks();
            List<Integer> integerList = List.of(random.nextInt(20), random.nextInt(20), random.nextInt(20));
            taskSubmission(integerList);
            countActiveCurrentTasks();
        }

        shutdown();

        for (Map.Entry<String, Integer> entry: map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        System.out.println(resultTask("task6"));
    }
}
