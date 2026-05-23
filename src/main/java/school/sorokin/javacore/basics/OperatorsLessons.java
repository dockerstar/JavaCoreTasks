package school.sorokin.javacore.basics;

import java.util.Scanner;

public class OperatorsLessons {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите первую переменную: ");
        int a = scanner.nextInt();

        System.out.println("Введите первую переменную: ");
        int b = scanner.nextInt();

        System.out.println("%s+%s=%s".formatted(a,b,(a+b)));
        System.out.println("%s-%s=%s".formatted(a,b,(a-b)));
        System.out.println("%sx%s=%s".formatted(a,b,(a*b)));
        System.out.println("%s>%s=%s".formatted(a,b,(a>b)));
        System.out.println("%s<%s=%s".formatted(a,b,(a<b)));
        System.out.println("%s==%s=%s".formatted(a,b,(a==b)));
        System.out.println("(%s+%s)>10 - %s".formatted(a,b,((a+b)>10)));
    }
}
