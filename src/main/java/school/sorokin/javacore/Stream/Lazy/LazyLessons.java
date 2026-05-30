package school.sorokin.javacore.Stream.Lazy;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class LazyLessons {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1,2,3,4,5,6,7,8,9,10);
        Optional<Integer> filter = numbers.stream()
                .peek(n->System.out.println("Текущий списко: " + n))
                .filter(n->n%2==0)
                .peek(n-> System.out.println("После изменения filter: " + n))
                .map(n->n*2)
                .peek(n-> System.out.println("После изменения map: " + n))
                .findFirst();

        System.out.println(filter);
    }
}
