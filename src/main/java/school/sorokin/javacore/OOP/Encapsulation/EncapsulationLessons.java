package school.sorokin.javacore.OOP.Encapsulation;

public class EncapsulationLessons {
    public static void main(String[] args) {
        People people = new People();
        people.setName("Vadim");
        people.setYear(20);
        System.out.println(people.getName() + " " + people.getYear());
    }
}
