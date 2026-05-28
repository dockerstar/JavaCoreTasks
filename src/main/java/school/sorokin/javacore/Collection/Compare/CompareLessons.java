package school.sorokin.javacore.Collection.Compare;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CompareLessons {
    public static void main(String[] args) {
        List<String> usersFromDb = new ArrayList<>();
        List<String> usersFromApi = new ArrayList<>();
        usersFromDb.add("Dima");
        usersFromDb.add("ALyona");
        usersFromDb.add("Dima");
        usersFromDb.add("Vadim");
        usersFromApi.add("Dima");
        usersFromApi.add("Renat");
        usersFromApi.add("Renat");
        usersFromApi.add("Vasya");


        System.out.println("Списки одинаковы? -  "+usersFromApi.equals(usersFromDb));
        //equals
        if (usersFromApi.size()==usersFromDb.size()) {
            System.out.println("Равны по размеру");
            for (int i =0; i<=usersFromDb.size()-1;i++) {
                if (usersFromApi.get(i).equals(usersFromDb.get(i))) {
                    System.out.println("%s элемент в списках равны".formatted(i));
                } else System.out.println("%s элемент в списках не равны".formatted(i));
            }
        } else System.out.println("Не равны по размеру");

        Set<String> apiSet = new HashSet<>(usersFromApi);
        Set<String> dbSet = new HashSet<>(usersFromDb);


        System.out.println("Списки одинаковы? -  "+apiSet.equals(dbSet));
        if (apiSet.size()!= dbSet.size()) {
            System.out.println("Сет данных списков не равны");
        } else System.out.println("Сет списков равны");

        List<String> searchEquals = new ArrayList<>();
        List<String> searchNoEq = new ArrayList<>();
        for (String api:apiSet) {
            for (String db : dbSet) {
                if (api.equals(db)) {
                    searchEquals.add(api);
                }
            }
        }
        for (String api:apiSet) {
            for (String s:searchEquals) {
                if (!api.equals(s)) {
                    searchNoEq.add(api);
                }
            }
        }
        for (String db:dbSet) {
            for (String s:searchEquals) {
                if (!db.equals(s)) {
                    searchNoEq.add(db);
                }
            }
        }
        System.out.println("Есть в обоих списках следующие имена: " + searchEquals);
        System.out.println("Имена есть только в своих списках: " + searchNoEq);
    }
}
