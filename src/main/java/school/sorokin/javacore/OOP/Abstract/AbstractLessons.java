package school.sorokin.javacore.OOP.Abstract;

public class AbstractLessons {
    public static void main(String[] args) {
        Sq s1 = new Sq("Sq1");
        Sq s2 = new Sq("Sq2");

        Sq[] ss = {s1, s2};
        for (Vehicle el: ss) {
            el.print();
            System.out.println(el.S(1,2));
            ((Sq) el).start();
            ((Sq) el).stop();
        }
    }
}
