package exception;

public class NoSuchDependencyException extends RuntimeException {
    public NoSuchDependencyException(String message) {
        super(message);
    }
}
