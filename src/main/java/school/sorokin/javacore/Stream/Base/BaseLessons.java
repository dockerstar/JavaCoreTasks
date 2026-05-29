package school.sorokin.javacore.Stream.Base;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BaseLessons {
    public static void main(String[] args) {
        List<String> stringList = List.of("Dima", "Vasya", "Alyona");
        String[] arrString = {"Vasya", "Oksana", "Dima"};

        Stream<String> stringStreamList = stringList.stream();
        Stream<String> stringStreamArr = Arrays.stream(arrString);
        Stream<String> stringStreamOf = Stream.of("Random", "Values");

        List<String> filterStreamList = filter(stringStreamList);
        System.out.println(filterStreamList);
        List<String> filterStreamArr = filter(stringStreamArr);
        System.out.println(filterStreamArr);
        List<String> filterStreamOf = filter(stringStreamOf);
        System.out.println(filterStreamOf);
    }

    public static List<String> filter(Stream<String> stream) {
        return stream.filter(s -> s.length()>=5)
                .map(s -> s.toUpperCase()).collect(Collectors.toList());
    }
}
