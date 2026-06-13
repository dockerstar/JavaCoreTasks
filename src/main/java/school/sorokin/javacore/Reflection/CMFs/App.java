package school.sorokin.javacore.Reflection.CMFs;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        try {
            Class<?> class1 = Person.class;
            Constructor[] constructors = class1.getDeclaredConstructors();
            Arrays.stream(constructors).forEach(System.out::println);

            Method[] methods = class1.getDeclaredMethods();
            Arrays.stream(methods).forEach(System.out::println);

            Field[] fields = class1.getDeclaredFields();
            Arrays.stream(fields).forEach(System.out::println);

            Constructor<?> constructor = class1.getConstructor(String.class, int.class);
            Person person = (Person) constructor.newInstance("Dima", 28);
            person.printInfo();
            Field name = class1.getDeclaredField("name");
            name.setAccessible(true);
            name.set(person, "vasya");
            Field year = class1.getDeclaredField("year");
            year.setAccessible(true);
            year.set(person, 21);
            person.printInfo();
            Method method = class1.getDeclaredMethod("last", int.class);
            method.setAccessible(true);
            method.invoke(person, 100);
            person.printInfo();
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException |
                 NoSuchFieldException e) {
            e.getCause();
        }
    }
}
