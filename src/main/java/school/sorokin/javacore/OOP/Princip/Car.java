package school.sorokin.javacore.OOP.Princip;

public class Car {
    String model;
    int year;

    void Start() {
        System.out.println("Car %s %s year going".formatted(model, year));
    }
}
