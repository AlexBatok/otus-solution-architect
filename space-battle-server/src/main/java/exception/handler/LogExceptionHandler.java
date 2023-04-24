package exception.handler;

import command.Command;
import command.queue.CommandQueue;
import command.wrapper.LogExceptionCommand;

public class LogExceptionHandler implements ExceptionHandler {

    private final CommandQueue commandQueue;

    public LogExceptionHandler(CommandQueue commandQueue) {
        this.commandQueue = commandQueue;
    }

    @Override
    public void handle(Command cmd, Exception ex) {
        commandQueue.addCommand(new LogExceptionCommand(ex, cmd));
    }
}
