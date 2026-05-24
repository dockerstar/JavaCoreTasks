package school.sorokin.javacore.OOP.TypeVariablesLessons;

import school.sorokin.javacore.OOP.Car;

public class TypeVariablesLessons {
    public static void main(String[] args) {
        int value = 10;
        changeValue(value);
        System.out.println(value);

        StringBuilder sb = new StringBuilder("Hello");
        changeSB(sb);
        System.out.println(sb);

        String s = new String("Ver1"); // del gc
        s = new String("Ver2"); // new obj
        System.out.println(s);
    }

    public static void changeValue(int num) {
        num = 20;
    }

    public static void changeSB(StringBuilder sbs) {
        sbs.append(" World");
    }
}
