package school.sorokin.javacore.Exception.App.Exception;

public class NoAvailableCopiesException extends Exception {
    public NoAvailableCopiesException(String message)
    {
        super(message);
    }

    public NoAvailableCopiesException(String message, Throwable cause) {
        super(message, cause);
    }
}
