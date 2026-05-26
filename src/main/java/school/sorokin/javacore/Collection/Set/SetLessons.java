package school.sorokin.javacore.Collection.Set;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetLessons {
    public static void main(String[] args) {
        Set<String> stringSet = new HashSet<>();
        stringSet.add("3");
        stringSet.add("2");
        stringSet.add("1");
        stringSet.add("1");
        System.out.println(stringSet);
        Set<String> linkedSet = new LinkedHashSet<>();
        linkedSet.add("1");
        linkedSet.add("2");
        linkedSet.add("3");
        linkedSet.add("1");
        System.out.println(linkedSet);
        Set<String> treeSet = new TreeSet<>();
        treeSet.add("3");
        treeSet.add("2");
        treeSet.add("1");
        treeSet.add("1");
        System.out.println(treeSet);


    }
}
