import org.junit.jupiter.api.*;
import school.sorokin.javacore.Testing.JUnit.DiscountCalculator;

public class DiscountCalculatorTest {
    private DiscountCalculator discountCalculator;

    @BeforeAll
    static void start() {
        System.out.println("Поехали");
    }

    @BeforeEach
    void init() {
        System.out.println("Выполнится при каждом тесте");
        discountCalculator = new DiscountCalculator();
    }

    @Test
    void testDiscountPriceOptimal() {
        double price = 200;
        double rate = 20;

        double result = discountCalculator.resultDiscCalc(price, rate);
        Assertions.assertEquals(160, result);
    }

    @Test
    void testDiscountPriceIsNotCorrectPrice() {
        double price = -200;
        double rate = 20;

        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            discountCalculator.resultDiscCalc(price, rate);
        });
        Assertions.assertEquals("Недопустимое значение", exception.getMessage());
    }

    @Test
    void testDiscountPriceIsNotCorrectRate() {
        double price = 200;
        double rate = -20;

        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            discountCalculator.resultDiscCalc(price, rate);
        });
        Assertions.assertEquals("Недопустимое значение", exception.getMessage());
    }

    @Test
    void testDiscountPriceIsNotCorrectAll() {
        double price = 0;
        double rate = 200;

        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            discountCalculator.resultDiscCalc(price, rate);
        });
        Assertions.assertEquals("Недопустимое значение", exception.getMessage());
    }

    @AfterAll
    static void end() {
        System.out.println("Выполняется после каждого теста");
    }
}
