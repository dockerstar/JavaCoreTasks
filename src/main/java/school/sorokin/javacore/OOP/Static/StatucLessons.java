package school.sorokin.javacore.OOP.Static;

public class StatucLessons {
    public static void main(String[] args) {
        System.out.println(Car.count);
        Car.changeCount();
        System.out.println(Car.count);
        Car car = new Car();
        System.out.println(car.name);
    }
}
