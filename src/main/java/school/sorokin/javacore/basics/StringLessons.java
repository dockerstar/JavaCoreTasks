package school.sorokin.javacore.basics;

public class StringLessons {
    public static void main(String[] args) {
        String str = "Это моя строка";

        System.out.println("Длина строки: " + str.length());
        System.out.println(str+" - а это я добавил к ней еще строку");
        String[] arrStr = str.split(" ");
        System.out.println("Количество слов в строке: " + arrStr.length);
        System.out.println("Эт я заменил слово - " + str.replace("моя", "не моя"));
        System.out.println(str.indexOf("с"));
        System.out.println(str.indexOf("о"));
    }
}
