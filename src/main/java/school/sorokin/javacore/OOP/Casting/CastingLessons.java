package school.sorokin.javacore.OOP.Casting;

import javax.sound.midi.Soundbank;

public class CastingLessons {
    public static void main(String[] args) {
        int a = 22201;
        long b = a; // неявное upcasting
        System.out.println(b);

        byte c = (byte) a; // яявное downcasting
        System.out.println(c);

        Animal catA = new Cat("CCats");
        Animal dogA = new Dog("Doogs");
        System.out.println(catA);
        System.out.println(dogA);

        if(catA instanceof Dog) {
            Cat catC = (Cat) catA;
            catC.catMethod();
            Animal catUp = catC;
            System.out.println(catUp);
        } else {
            System.out.println("Нооо");
        }

        if (dogA instanceof Dog) {
            Dog dogD = (Dog) dogA;
            dogD.dogsMethod();
        } else {
            System.out.println("Нооо");
        }
    }

}
