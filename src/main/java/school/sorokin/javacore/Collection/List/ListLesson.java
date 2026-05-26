package school.sorokin.javacore.Collection.List;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListLesson {
    public static void main(String[] args) {
        long startAr = System.nanoTime();
        List<String> stringList = new ArrayList<>();
        stringList.add("1 элемент");
        stringList.add("2 элемент");
        stringList.add("3 элемент");
        stringList.add("4 элемент");
        long endAr = System.nanoTime();
        System.out.println("Затраченное время на добавление 4 элементов в Arr: " + (endAr-startAr));
        startAr = System.nanoTime();
        stringList.add(2, "new");
        stringList.remove(3);
        endAr = System.nanoTime();
        System.out.println("Затраченное время на довбление и удаление 1 элемента с середины Arr: "+(endAr-startAr));


        long startL = System.nanoTime();
        List<String> stringListLin = new LinkedList<>();
        stringListLin.add("1 элемент");
        stringListLin.add("2 элемент");
        stringListLin.add("3 элемент");
        stringListLin.add("4 элемент");
        long endL = System.nanoTime();
        System.out.println("Затраченное время на добавление 4 элементов в Lin: " + (endL-startL));
        startL = System.nanoTime();
        stringListLin.add(2, "new");
        stringListLin.remove(3);
        endL = System.nanoTime();
        System.out.println("Затраченное время на довбление и удаление 1 элемента с середины Lin: "+(endL-startL));
    }
}
