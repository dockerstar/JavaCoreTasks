package school.sorokin.javacore.basics;

public class VariablesLessons {
    public static void main(String[] args) {
        int count;
        double price;
        boolean buy;
        char oneSymbol;

        count = 5;
        price = 12.5;
        buy = false;
        oneSymbol = 'B';

        System.out.println("%s, %s, %s, %s".formatted(count, price, buy, oneSymbol));
    }
}
