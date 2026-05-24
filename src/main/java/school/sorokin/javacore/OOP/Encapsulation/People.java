package school.sorokin.javacore.OOP.Encapsulation;

public class People {
    private String name;
    private int year;

    public void setName(String name) {
        this.name = name;
    }

    public void setYear(int year) {
        if(year<0) {
            System.out.println("Значение не может быть меньше нуля");
            return;
        }
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }
}
