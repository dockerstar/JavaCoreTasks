package school.sorokin.javacore.Reflection.CMFs;

public class Person {
    private String name;
    private int year;

    public Person(String name, int year) {
        this.name = name;
        this.year = year;
    }

    public void printInfo() {
        System.out.println(name + " " + year);
    }

    private void last(int year) {
        this.name=null;
        this.year=year;
    }


}
