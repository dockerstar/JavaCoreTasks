package school.sorokin.javacore.Exception.ExceptionHandlingLesson;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ExceptionHandlingApp {
    public static void main(String[] args) {
        runScenario();
        System.out.println("Работаем, братья");
    }

    static void runScenario() {
        Logger logger = Logger.getLogger(ExceptionHandlingApp.class.getName());

        try {
            int a = 10/2;
            String[] arr = {"123", "asd"};
            System.out.println(arr[2]);
        } catch (ArithmeticException e) {
            logger.log(Level.OFF, "Ошибка деления на ноль нельзя ", e.getClass().getSimpleName());
        } catch (ArrayIndexOutOfBoundsException e) {
            logger.log(Level.OFF, "Вышел за пределы ", e.getClass().getSimpleName());
        } finally {
            logger.log(Level.INFO, " Работает дальше ");
        }
    }
}
