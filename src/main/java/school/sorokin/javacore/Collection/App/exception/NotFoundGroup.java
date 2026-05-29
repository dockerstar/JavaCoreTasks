package school.sorokin.javacore.Collection.App.exception;

public class NotFoundGroup extends RuntimeException {
    public NotFoundGroup(String message) {
        super(message);
    }
    public NotFoundGroup(String message, Throwable cause) {
        super(message, cause);
    }
}
