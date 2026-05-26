package school.sorokin.javacore.OOP.App.repository;

import school.sorokin.javacore.OOP.App.model.Book;
import school.sorokin.javacore.OOP.App.model.Magazine;
import school.sorokin.javacore.OOP.App.model.Newspaper;
import school.sorokin.javacore.OOP.App.model.Publication;

import java.util.ArrayList;
import java.util.List;

public class Library {
    List<Publication> publicationList = new ArrayList<>();

    public void addPublication(Publication pub) {
        publicationList.add(pub);
    }

    public void listPublication() {
        if (publicationList.isEmpty()) {
            System.out.println("Публикаций пока нет");
        } else {
            for (Publication pub : publicationList) {
                if (pub instanceof Book) {
                    ((Book) pub).printDetails();
                } else if (pub instanceof Magazine) {
                    ((Magazine) pub).printDetails();
                } else if (pub instanceof Newspaper) {
                    ((Newspaper) pub).printDetails();
                }
            }
        }
    }

    public void searchByAuthor(String author) {
        List<Publication> searchList = new ArrayList<>();
        for (Publication pub : publicationList) {
            if (pub.getAuthor().equals(author)) {
                searchList.add(pub);
            }
        }
        if (searchList.isEmpty()) {
            System.out.println("Публикаций пока нет");
        } else {
            for (Publication pub : searchList) {
                if (pub instanceof Book) {
                    ((Book) pub).printDetails();
                } else if (pub instanceof Magazine) {
                    ((Magazine) pub).printDetails();
                } else if (pub instanceof Newspaper) {
                    ((Newspaper) pub).printDetails();
                }
            }
        }
    }
}
