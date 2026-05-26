package school.sorokin.javacore.Exception.App;

import school.sorokin.javacore.Exception.App.Exception.ItemNotFoundException;
import school.sorokin.javacore.Exception.App.Exception.NoAvailableCopiesException;
import school.sorokin.javacore.Exception.App.model.Book;
import school.sorokin.javacore.Exception.App.repository.Library;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger(App.class.getName());
        Library library = new Library();
        String menu = """
                1. Вывести каталог.
                2. Добавить объект.
                3. Выдать объект.
                4. Вернуть объект.
                5. Выйти из приложения.
                """;
        System.out.println(menu);
        System.out.println(" ");
        System.out.println("Выберите пункт меню");
        Scanner scanner = new Scanner(System.in);
        int optionMenu = scanner.nextInt();
        scanner.nextLine();
        while (optionMenu != 5) {
            try {
                switch (optionMenu) {
                    case 1 -> {
                        List<Book> bookList = library.getAllBooks();
                        for (Book book : bookList) {
                            System.out.println(book);
                        }
                        System.out.println(" ");
                    }
                    case 2 -> {
                        System.out.println("Укжаите название книги: ");
                        String title = scannerTestLine();
                        System.out.println("Укажите автора книги: ");
                        String author = scannerTestLine();
                        System.out.println("Укажите количество копий книги: ");
                        int countCopies = scanner.nextInt();
                        library.addBook(title, author, countCopies);
                        System.out.println(" ");
                    }
                    case 3 -> {
                        System.out.println("Введите название книги, которую хотите получить: ");
                        String title = scannerTestLine();
                        library.takeBook(title);
                        System.out.println(" ");
                    }
                    case 4 -> {
                        System.out.println("Введите название книги, которую хотите вернуть");
                        String title = scannerTestLine();
                        library.returnBook(title);
                        System.out.println(" ");
                    }
                    default -> System.out.println("нет такого пункта");
                }
            } catch (InputMismatchException e) {
                logger.log(Level.WARNING, "Не соответсвует типу: " + e.getClass().getSimpleName());
                scanner.nextLine();
            } catch (NoAvailableCopiesException | ItemNotFoundException e) {
                logger.log(Level.WARNING, e.getClass().getSimpleName() + " " + e.getMessage());
            }

            if (optionMenu!=5) {
                System.out.println("Выберите пункт меню");
                optionMenu = scanner.nextInt();
                scanner.nextLine();
            }
        }
    }

    public static String scannerTestLine() {
        Scanner scanner = new Scanner(System.in);
        String str;
        do {
            str = scanner.nextLine().trim();
            if (str.isEmpty()) {
                System.out.println("Строка не должна быть пустой");
            }
        } while (str.isEmpty());
        return str;
    }
}
