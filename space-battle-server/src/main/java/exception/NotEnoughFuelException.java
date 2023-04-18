package exception;

public class NotEnoughFuelException extends CommandException {
    public NotEnoughFuelException() {
        super("Not enough fuel");
    }
}
