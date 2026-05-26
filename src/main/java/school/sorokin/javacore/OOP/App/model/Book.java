package school.sorokin.javacore.OOP.App.model;

import java.util.Objects;

public class Book extends Publication implements Printable{
    private String ISBN;

    public Book(String title, String author, int year, String ISBN) {
        super(title, author, year);
        this.ISBN = ISBN;
    }

    @Override
    public String getType() {
        return "Book";
    }

    public String getISBN() {
        return ISBN;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Book book = (Book) o;
        return Objects.equals(ISBN, book.ISBN);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), ISBN);
    }

    @Override
    public void printDetails() {
        System.out.println(getType() + " - ISBN: " + ISBN + " Titile: " + getTitle() + " Author: " + getAuthor());
    }
}
