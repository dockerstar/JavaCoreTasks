package school.sorokin.javacore.Introduction;

import java.util.Scanner;

public class MyFirstProgram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userInput;
        int age;

        System.out.println("Введите ваше имя: ");
        userInput = scanner.nextLine();

        System.out.println("Введите ваш возраст: ");
        age = scanner.nextInt();

        System.out.println("Привет, %s! Тебе %s лет".formatted(userInput, age));
    }
}
