package school.sorokin.javacore.Collection.EH;

import school.sorokin.javacore.Collection.EH.model.User;

import java.util.HashMap;
import java.util.HashSet;

public class EHLessons {
    public static void main(String[] args) {
        User user1 = new User(1, "Dima");
        User user2 = new User(2, "Vadim");
        User user3 = new User(1, "Vanya");

        HashMap<User, String> userStringHashMap = new HashMap<>();
        userStringHashMap.put(user1, "AAAA");
        userStringHashMap.put(user2, "BBB");

        System.out.println(userStringHashMap.get(user3));

        user1.setId(3);
        userStringHashMap.put(user1, "CCCC");

        System.out.println(userStringHashMap.get(user3));

    }
}
