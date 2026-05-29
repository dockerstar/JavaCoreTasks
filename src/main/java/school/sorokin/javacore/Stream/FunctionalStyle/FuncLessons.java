package school.sorokin.javacore.Stream.FunctionalStyle;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FuncLessons {
    public static void main(String[] args) {
        List<Integer> evaluations = List.of(1, 2, 3, 4, 5);
        List<Integer> filterList = new ArrayList<>();
        for (Integer ev:evaluations) {
            if (ev>=3) filterList.add(ev);
        }
        System.out.println(filterList);

        filterList = evaluations.stream().filter(ev -> ev>=3).collect(Collectors.toList());
        System.out.println(filterList);
    }
}
