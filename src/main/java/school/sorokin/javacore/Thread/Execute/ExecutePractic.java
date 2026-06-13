package school.sorokin.javacore.Thread.Execute;

import java.util.concurrent.*;

public class ExecutePractic {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        Callable<String> callable = () -> {
          Thread.sleep(3000);
          return "result";
        };

        Future<String> future = executorService.submit(callable);

        try {
            String result = future.get(4, TimeUnit.SECONDS);
            System.out.println("Задача завершена - " + result);
        } catch (TimeoutException e) {
            System.out.println("Задача долго выполняется, отмена");
            future.cancel(true);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            executorService.shutdown();
        }
    }
}
