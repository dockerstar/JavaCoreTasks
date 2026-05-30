package school.sorokin.javacore.Stream.Intermedia;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IntermidaLessons {
    public static void main(String[] args) {
        List<String> stringList = List.of("Меня зовут Дима", "Погода хорошая", "БМВ", "БМВ", "Крым");
        Stream<String> stream = stringList.stream();

        List<String> filterStream1 = stream.filter(s -> s.length()>5).collect(Collectors.toList());
        System.out.println(filterStream1);
        List<String> filterStream2 = stringList.stream().distinct().skip(2).collect(Collectors.toList());
        System.out.println(filterStream2);
    }
}
