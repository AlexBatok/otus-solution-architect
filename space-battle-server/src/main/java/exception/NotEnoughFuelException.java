package exception;

public class NotEnoughFuelException extends RuntimeException {
    public NotEnoughFuelException() {
        super("Not enough fuel");
    }
}
