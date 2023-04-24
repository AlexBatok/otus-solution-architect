package command.wrapper;

import command.Command;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogExceptionCommand implements CommandWrapper {
    private static final Logger LOGGER = LoggerFactory.getLogger(LogExceptionCommand.class);
    private final Exception exception;
    private final Command command;

    public LogExceptionCommand(Exception exception, Command command) {
        this.exception = exception;
        this.command = command;
    }

    @Override
    public void execute() {
        LOGGER.error(String.format("Command %s threw the exception with the message: %s",
                command.getClass().getName(), exception.getMessage()), exception);
    }
}
