package school.sorokin.javacore.OOP.App.model;

import java.time.Instant;
import java.util.Objects;

public class Newspaper extends Publication implements Printable {
    private Instant publicationDay;

    public Newspaper(String title, String author, int year) {
        super(title, author, year);
        this.publicationDay = Instant.now();
    }

    @Override
    public String getType() {
        return "Newspaper";
    }

    public Instant getPublicationDay() {
        return publicationDay;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Newspaper newspaper = (Newspaper) o;
        return Objects.equals(publicationDay, newspaper.publicationDay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), publicationDay);
    }

    @Override
    public void printDetails() {
        System.out.println(getType() + " - publicationDay: " + publicationDay + " Titile: " + getTitle() + " Author: " + getAuthor());
    }
}
