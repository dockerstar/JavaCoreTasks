package school.sorokin.javacore.OOP.Static;

public class Car {
    public static int count = 0;
    public static void changeCount() {
        count++;
    }

    public final String name = "This class name Car";
}
