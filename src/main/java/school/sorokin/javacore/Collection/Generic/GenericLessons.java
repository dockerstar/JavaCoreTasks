package school.sorokin.javacore.Collection.Generic;

import school.sorokin.javacore.Exception.App.repository.Library;

import java.util.ArrayList;
import java.util.List;

public class GenericLessons {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("123");
        stringList.add("ddd");
        for (String s:stringList) {
            System.out.println(s);
        }

        List list = new ArrayList<>();
        list.add("as");
        list.add(1);
        String str = (String) list.get(1);
        System.out.println(str);
    }
}
