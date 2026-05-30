package school.sorokin.javacore.Stream.Terminal;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class TerminalLessons {
    public static void main(String[] args) {
        List<Integer> priceList = List.of(20, 1000, 300, 445);
        List<Integer> filterPrice = priceList.stream()
                .filter(p -> p>=300)
                .collect(Collectors.toList());
        System.out.println(filterPrice);

        long countPrice = filterPrice.stream().count();
        System.out.println(countPrice);

        priceList.stream().filter(p->p>=300).forEach(System.out::println);
    }
}
