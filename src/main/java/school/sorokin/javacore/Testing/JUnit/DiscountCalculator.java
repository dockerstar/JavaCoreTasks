package school.sorokin.javacore.Testing.JUnit;

public class DiscountCalculator {
    public double resultDiscCalc(double price, double rate) {
        if ((rate<0 || rate>100) || price<=0) {
            throw new IllegalArgumentException("Недопустимое значение");
        } else return price-(price/100)*rate;
    }
}
