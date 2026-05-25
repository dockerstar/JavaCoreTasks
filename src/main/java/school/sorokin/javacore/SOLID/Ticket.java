package school.sorokin.javacore.SOLID;

public class Ticket {
    private String title;

    public Ticket(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "title='" + title + '\'' +
                '}';
    }
}
