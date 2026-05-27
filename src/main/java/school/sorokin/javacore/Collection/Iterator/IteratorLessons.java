package school.sorokin.javacore.Collection.Iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorLessons {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("read book");
        stringList.add("send email");
        stringList.add("done: clean room");
        stringList.add("done: buy food");
        stringList.add("write code");

        for (String s:stringList) {
            if (s.contains("done")) {
                stringList.remove(s);
            }
        }



//        Iterator<String> stringIterator = stringList.iterator();
//
//        while (stringIterator.hasNext()) {
//            if (stringIterator.next().contains("done")) {
//                stringIterator.remove();
//            }
//        }

        for (String s:stringList) {
            System.out.println(s);
        }


    }
}
