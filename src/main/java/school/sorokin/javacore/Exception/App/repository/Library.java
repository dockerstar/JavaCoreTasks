package school.sorokin.javacore.Exception.App.repository;

import school.sorokin.javacore.Exception.App.Exception.ItemNotFoundException;
import school.sorokin.javacore.Exception.App.Exception.NoAvailableCopiesException;
import school.sorokin.javacore.Exception.App.model.Book;

import java.util.ArrayList;
import java.util.List;

public class Library {
    List<Book> bookList = new ArrayList<>();

    public void addBook(String title, String author, int copies) {
        Book book = new Book(title, author, copies);
        bookList.add(book);
    }

    public void takeBook(String title) throws NoAvailableCopiesException, ItemNotFoundException {
        for (Book book:bookList) {
            if (book.getTitle().equals(title)) {
                if (book.getAvailableCopies()!=0) {
                    book.setAvailableCopies(book.getAvailableCopies()-1);
                    System.out.println("Книга успешно выдана!");
                    System.out.println(book);
                } else throw new NoAvailableCopiesException("Копий данной книги больше не осталось");
            } else throw new ItemNotFoundException("Книга не найдена");
        }
    }

    public void returnBook(String title) throws ItemNotFoundException {
        boolean status = false;
        for (Book book:bookList) {
            if (book.getTitle().equals(title)) {
                book.setAvailableCopies(book.getAvailableCopies()+1);
                status = true;
                System.out.println("Книга возвращена");
                System.out.println(book);
            }
        }
        if (!status) throw new ItemNotFoundException("Книга не найдена");
    }

    public List<Book> getAllBooks() {
        return bookList;
    }
}
