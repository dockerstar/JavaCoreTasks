package school.sorokin.javacore.Exception.Example;

public class OrderValidationException extends Exception {
    public OrderValidationException(String message, Throwable cause) {
        super(message, cause);
    }
    public OrderValidationException(String message) {
        super(message);
    }
}
