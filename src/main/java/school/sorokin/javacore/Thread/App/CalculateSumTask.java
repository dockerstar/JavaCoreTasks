package school.sorokin.javacore.Thread.App;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

public class CalculateSumTask implements Callable<Integer> {
    public static final AtomicInteger completedCountTasks = new AtomicInteger(0);
    private List<Integer> integerList;
    private Integer sum = 0;
    private String taskName;

    CalculateSumTask(List<Integer> integerList, String taskName) {
        this.integerList=integerList;
        this.taskName=taskName;
    }

    public List<Integer> getIntegerList() {
        return integerList;
    }

    public Integer getSum() {
        return sum;
    }

    public String getTaskName() {
        return taskName;
    }

    @Override
    public Integer call()  {
        System.out.println("Name thread: " + Thread.currentThread().getName());
        System.out.println("Name task: " + taskName);
        try {
            integerList.forEach(integer -> System.out.print(integer + " "));
            System.out.println("");
            Thread.sleep(2000);
            for (Integer integer:integerList) {
                sum+=integer;
            }
            System.out.println("Result: " + sum);
            return sum;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            completedCountTasks.incrementAndGet();
        }
    }
}
