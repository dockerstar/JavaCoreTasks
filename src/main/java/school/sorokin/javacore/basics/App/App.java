package school.sorokin.javacore.basics.App;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите размер телефонной книжки:");
        int max = scanner.nextInt();

        String[] names = new String[max];
        String[] phones = new String[max];

        String menuItem = """
                1. Добавить контакт, 
                2. Просмотреть контакты, 
                3. Найти контакт, 
                4. Удалить контакт,
                5. Выйти
                """;

        System.out.println(menuItem);
        int count = 0;
        System.out.println("Выбери пункт меню: ");
        String command = scanner.nextLine();
        while (!command.equals("5")) {
            switch (command) {
                case "1" -> {
                    if (max!=0) {
                        System.out.print("Введите имя: ");
                        names[count] = scanner.nextLine().trim();
                        if(names[count].equals("")) {
                            System.out.println("Строка не должна быть пустой");
                            continue;
                        }
                        System.out.print("Введите номер телефона: ");
                        phones[count] = scanner.nextLine().trim();
                        if(phones[count].equals("")) {
                            System.out.println("Строка не должна быть пустой");
                            continue;
                        }
                        count++;
                        System.out.println(" ");
                        max--;
                    } else {
                        System.out.println("Телефонная книжка переполнена");
                    }
                }
                case "2" -> {
                    if (count!=0) {
                        for (int i =0 ; i<count;i++) {
                            System.out.println((i+1) + ". " + names[i] + " - " + phones[i]);
                        }
                    } else {
                        System.out.println("Телефонная книжка пуста");
                    }
                    System.out.println(" ");
                }
                case "3" -> {
                    boolean searchStatus = false;
                    System.out.println("Введите имя, которое хотите найти: ");
                    String searchName = scanner.nextLine().trim();
                    if(searchName.equals("")) {
                        System.out.println("Строка не должна быть пустой");
                        continue;
                    }
                    for(int i = 0; i<names.length; i++) {
                        if(searchName.equals(names[i])) {
                            System.out.println("Номер телефона %s: %s" .formatted(names[i], phones[i]));
                            searchStatus = true;
                        }
                    }
                    if(!searchStatus) {
                        System.out.println("Клиент с именем %s не найден".formatted(searchName));
                    }
                    System.out.println(" ");
                }
                case "4" -> {
                    int searchIndex;
                    boolean searchStatus = false;
                    System.out.println("Ведите имя, которое хотите удалить из телефонной книжки: ");
                    String searchName = scanner.nextLine().trim();
                    if(searchName.equals("")) {
                        System.out.println("Строка не должна быть пустой");
                        continue;
                    }
                    for(int i = 0; i<names.length; i++) {
                        if(searchName.equals(names[i])) {
                            searchStatus = true;
                            for (searchIndex = i; searchIndex< names.length-1;searchIndex++) {
                                names[searchIndex] = names[searchIndex+1];
                                phones[searchIndex] = phones[searchIndex+1];
                            }
                            count--;
                            System.out.println("Контакт удален");
                        }
                    }
                    if(!searchStatus) {
                        System.out.println("Клиент с именем %s не найден".formatted(searchName));
                    }
                    System.out.println(" ");
                }
                default -> {
                    System.out.println("Выбирай пункт меню из указанного списка");
                    System.out.println(menuItem);
                    System.out.println(" ");
                }
            }
            System.out.println("Выбери пункт меню: ");
            command = scanner.nextLine();
        }
    }
}
