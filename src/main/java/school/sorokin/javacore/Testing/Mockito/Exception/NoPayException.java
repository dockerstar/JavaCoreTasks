package school.sorokin.javacore.Testing.Mockito.Exception;

public class NoPayException extends RuntimeException {
    public NoPayException(String message, Throwable cause) {
        super(message, cause);
    }
    public NoPayException(String message) {
        super(message);
    }
}
