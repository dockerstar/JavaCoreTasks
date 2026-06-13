package school.sorokin.javacore.Reflection.Introdaction;

import java.lang.reflect.*;
import java.nio.file.WatchEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) {
        try {
            Class<?> class1 = User.class;
            System.out.println(class1.getSimpleName());
            System.out.println(class1.accessFlags());
            Method[] methods = class1.getDeclaredMethods();
            Stream<Method> stream = Arrays.stream(methods);
            stream.map(m->m.getName()).forEach(System.out::println);

            Field[] fields = class1.getDeclaredFields();
            Stream<Field> stream1 = Arrays.stream(fields);
            stream1.map(f->f.getName()).forEach(System.out::println);



            Constructor<?> constructor = class1.getDeclaredConstructor();
            constructor.setAccessible(true);
            User user1 = (User) constructor.newInstance();
            System.out.println(user1);
            Field field = class1.getDeclaredField(  "password");
            field.setAccessible(true);
            field.set(user1, "123");
            System.out.println(user1);
            Method method = class1.getDeclaredMethod("secretPass", String.class);
            method.setAccessible(true);
            method.invoke(user1, "eeeeee");
            System.out.println(user1);
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchFieldException e) {
            e.getCause();
        }
    }
}
