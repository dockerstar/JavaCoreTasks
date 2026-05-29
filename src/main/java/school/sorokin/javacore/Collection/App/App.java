package school.sorokin.javacore.Collection.App;

import school.sorokin.javacore.Collection.App.exception.NotFoundContact;
import school.sorokin.javacore.Collection.App.exception.NotFoundGroup;
import school.sorokin.javacore.Collection.App.model.Contact;
import school.sorokin.javacore.Collection.App.repository.ContactRepository;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger(App.class.getName());
        ContactRepository contactRepository = new ContactRepository();
        String menu = """
                Выберите пункт меню:
                «1»: Добавить контакт
                «2»: Удалить контакт
                «3»: Посмотреть все контакты
                «4»: Найти контакт
                «5»: Посмотреть контакты по группе
                «0»: Выход
                """;
        System.out.println(menu);
        String option = scanString();
        while (!option.equals("0")) {
            try {
                switch (option) {
                    case "1" -> {
                        System.out.print("Введи имя: ");
                        String name = scanString();
                        System.out.print("Введи телефон: ");
                        String phone = scanString();
                        System.out.print("Введи email: ");
                        String email = scanString();
                        System.out.print("Введи группу: ");
                        String group = scanString();
                        Contact contact = new Contact(name, phone, email, group);
                        contactRepository.save(contact);
                        System.out.println("Контакт сохранен: " + contact + "\n");
                    }
                    case "2" -> {
                        System.out.print("Введи имя контакта: ");
                        String name = scanString();
                        System.out.print("Введи телефон: ");
                        String phone = scanString();
                        contactRepository.delete(name, phone);
                        System.out.println("Контакт '" + name + " " + phone + "' " + "удален!\n" );
                    }
                    case "3" -> contactRepository.getAll();
                    case "4" -> {
                        System.out.print("Введи имя: ");
                        String name = scanString();
                        System.out.print("Введи телефон: ");
                        String phone = scanString();
                        System.out.println(contactRepository.get(name, phone) + "\n");
                    }
                    case "5" -> {
                        System.out.print("Введи название группы: ");
                        String group = scanString();
                        System.out.println(contactRepository.getAllContactsInGroup(group));
                    }
                    default -> {
                        System.out.println("Нет такого пункта меню!");
//                        System.out.println(menu);
//                        option = scanString();
                    }
                }
            } catch (NotFoundContact | NotFoundGroup e) {
                logger.log(Level.WARNING, e.getMessage());
            }
            System.out.println(menu);
            option = scanString();
        }
    }

    public static String scanString() {
        Scanner scanner = new Scanner(System.in);
        String option;
        do {
            option = scanner.nextLine().trim();
            if (option.isEmpty()) System.out.println("Строка не может быть пустой");
        } while (option.isEmpty());
        return option;
    }
}
