package school.sorokin.javacore.Collection.App.exception;

public class NotFoundContact extends RuntimeException {
    public NotFoundContact(String message) {
        super(message);
    }

    public NotFoundContact(String message, Throwable cause) {
        super(message, cause);
    }
}
