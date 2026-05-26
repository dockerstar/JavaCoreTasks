package school.sorokin.javacore.OOP.App;

import school.sorokin.javacore.OOP.App.model.Book;
import school.sorokin.javacore.OOP.App.model.Magazine;
import school.sorokin.javacore.OOP.App.model.Newspaper;
import school.sorokin.javacore.OOP.App.model.Publication;
import school.sorokin.javacore.OOP.App.repository.Library;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Library library = new Library();
        System.out.println("""
                Опция 1: Добавить новую публикацию.
                Опция 2: Вывести список всех публикаций.
                Опция 3: Поиск публикации по автору.
                Опция 4: Вывести общее количество публикаций (используя статический метод).
                Опция 0: Выход.
                """);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите пункт меню");
        String option = scanner.nextLine();
        while (!option.equals("0")) {
            switch (option) {
                case "1" -> {
                    System.out.println("""
                            Выберите тип публикации, которую хотите опубликовать или пункт меню, чтобы выйтит:
                            1. Book
                            2. Magazine
                            3. Newspaper
                            4. Выйти
                            """);
                    String typePub = scanner.nextLine();
                    while (!typePub.equals("4")) {
                        switch (typePub) {
                            case "1" -> {
                                System.out.println("Введите title: ");
                                String title = scanner.nextLine();
                                System.out.println("Введите author: ");
                                String author = scanner.nextLine();
                                System.out.println("Введите year: ");
                                int year = Integer.parseInt(scanner.nextLine());
                                System.out.println("Введите ISBN: ");
                                String ISBN = scanner.nextLine();
                                Publication publication = new Book(title, author, year, ISBN);
                                library.addPublication(publication);
                                System.out.println("Публикация добавлена");
                                System.out.println(" ");
                            }
                            case "2" -> {
                                System.out.println("Введите title: ");
                                String title = scanner.nextLine();
                                System.out.println("Введите author: ");
                                String author = scanner.nextLine();
                                System.out.println("Введите year: ");
                                int year = Integer.parseInt(scanner.nextLine());
                                System.out.println("Введите issueNumber: ");
                                String issueNumber = scanner.nextLine();
                                Publication publication = new Magazine(title, author, year, issueNumber);
                                library.addPublication(publication);
                                System.out.println("Публикация добавлена");
                                System.out.println(" ");
                            }
                            case "3" -> {
                                System.out.println("Введите title: ");
                                String title = scanner.nextLine();
                                System.out.println("Введите author: ");
                                String author = scanner.nextLine();
                                System.out.println("Введите year: ");
                                int year = Integer.parseInt(scanner.nextLine());
                                Publication publication = new Newspaper(title, author, year);
                                library.addPublication(publication);
                                System.out.println("Публикация добавлена");
                                System.out.println(" ");
                            }
                            default -> {
                                System.out.println("""
                                    Выберите тип публикации, которую хотите опубликовать или пункт меню, чтобы выйтит:
                                    1. Book
                                    2. Magazine
                                    3. Newspaper
                                    4. Выйти
                                    """);
                                System.out.println(" ");
                            }
                        }
                        System.out.println("""
                                Выберите тип публикации, которую хотите опубликовать или пункт меню, чтобы выйтит:
                                1. Book
                                2. Magazine
                                3. Newspaper
                                4. Выйти
                                """);
                        typePub = scanner.nextLine();
                    }
                }
                case "2" -> {
                    library.listPublication();
                    System.out.println(" ");
                }
                case "3" -> {
                    System.out.println("Введи автора");
                    String author = scanner.nextLine();
                    library.searchByAuthor(author);
                    System.out.println(" ");
                }
                case "4" -> {
                    System.out.println("Общее количество публикаций = " + Publication.getPublicationCount());
                    System.out.println(" ");
                }
                default -> System.out.println("""
                        Опция 1: Добавить новую публикацию.
                        Опция 2: Вывести список всех публикаций.
                        Опция 3: Поиск публикации по автору.
                        Опция 4: Вывести общее количество публикаций (используя статический метод).
                        Опция 0: Выход.
                        """);
            }
            System.out.println("""
                        Опция 1: Добавить новую публикацию.
                        Опция 2: Вывести список всех публикаций.
                        Опция 3: Поиск публикации по автору.
                        Опция 4: Вывести общее количество публикаций (используя статический метод).
                        Опция 0: Выход.
                        """);
            option = scanner.nextLine();
        }
    }
}
