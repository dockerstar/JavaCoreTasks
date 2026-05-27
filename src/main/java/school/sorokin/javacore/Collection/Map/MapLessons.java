package school.sorokin.javacore.Collection.Map;

import javax.sound.midi.Soundbank;
import java.util.*;

public class MapLessons {
    public static void main(String[] args) {
        Map<String, Integer> stock = new HashMap<>();
        stock.put("Apple", 1);
        stock.put("Banana", 4);
        stock.put("Orange", 3);
        stock.put("Milk", 2);
        Scanner scanner = new Scanner(System.in);
        System.out.println(stock);
        String menu = """
                1. Добавить
                2. Удалить
                """;
        System.out.println(menu);
        System.out.println("Выбери опцию");
        int option = scanner.nextInt();
        scanner.nextLine();
        while (option != 0) {
            switch (option) {
                case 1 -> {
                    System.out.println("Введи какой товар хочешь добавить: ");
                    String item = scanner.nextLine().trim();
                    if (stock.containsKey(item)) {
                        for (Map.Entry<String, Integer> entry : stock.entrySet()) {
                            if (entry.getKey().equals(item)) {
                                stock.put(item, entry.getValue() + 1);
                                System.out.println("Добавили товар: " + entry.getKey() + " " + entry.getValue());
                                break;
                            }
                        }
                    } else {
                        System.out.println("такого товара нет, введи количетсво товара, чтобы добавить в мап: ");
                        Integer count = scanner.nextInt();
                        if (count>0) {
                            scanner.nextLine();
                            stock.put(item, count);
                            System.out.println("Товар добавлен ");
                        } else System.out.println("Количество не может быть меньше 1");

                    }
                    System.out.println(stock);
                    System.out.println(" ");
                }
                case 2 -> {
                    System.out.println("Введи какой товар хочешь продать: ");
                    String itemBuy = scanner.nextLine();
                    if (stock.containsKey(itemBuy)) {
                        for (Map.Entry<String, Integer> entry : stock.entrySet()) {
                            if (entry.getKey().equals(itemBuy)) {
                                if (entry.getValue()>0) {
                                    stock.put(itemBuy, entry.getValue() - 1);
                                    break;
                                } else System.out.println("Товар закончился");
                            }
                        }
                    } else {
                        System.out.println("Такого товара нет");
                    }
                    System.out.println(stock);
                    System.out.println(" ");
                }
                default -> System.out.println("Нет такого пункта меню");
            }
            System.out.println("Выбери опцию");
            option = scanner.nextInt();
            scanner.nextLine();
        }
    }
}
