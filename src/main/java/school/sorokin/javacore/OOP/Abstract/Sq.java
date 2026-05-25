package school.sorokin.javacore.OOP.Abstract;

public class Sq extends Vehicle implements PullMethod {
    String type;

    Sq(String type) {
        this.type = type;
    }

    @Override
    int S(int x, int y) {
        return x*y;
    }

    @Override
     void print() {
        System.out.println(type);
    }

    @Override
    public void start() {
        System.out.println(type + " " + "start - " + name);
    }

    @Override
    public void stop() {
        System.out.println(type + " " + "stop: - " + name);
    }
}
