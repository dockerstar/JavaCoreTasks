package school.sorokin.javacore.basics;

import java.util.Scanner;

public class ConditionalLessons {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите значение переменной: ");
        int a = scanner.nextInt();

        if(a>10) {
            System.out.println("%s>10 - %s".formatted(a, (a>10)));
        } else if(a==10) {
            System.out.println("%s==10 - %s".formatted(a, (a==10)));
        } else {
            System.out.println("%s<10 - %s".formatted(a, (a>10)));
        }
    }
}
