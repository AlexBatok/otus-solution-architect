package exception.command;

public class CommandException extends RuntimeException {
    public CommandException(Throwable cause) {
        super(cause);
    }
}
