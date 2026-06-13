package school.sorokin.javacore.Thread.CompletableFuture;

import java.util.concurrent.CompletableFuture;

public class App {
    public static CompletableFuture<String> task(String s) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return s + "ss ";
        });
    }
    public static void main(String[] args) {
        CompletableFuture<String> myTask = task("job");
        CompletableFuture<String> twoTask = task("rest");

        CompletableFuture<String> resMy =  myTask
                .thenCombine(twoTask, (s, b) -> {
                    return s + " " + b;
                })
                        .thenApply(s -> s + " скомбинировали")
                                .handle((s, ex) -> {
                                    if (!s.isEmpty()) {
                                        System.out.println(ex.getMessage());
                                        return "нет нэма ничего";
                                    } else {
                                        return s;
                                    }
                                });


        resMy.thenAccept(System.out::println);

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
