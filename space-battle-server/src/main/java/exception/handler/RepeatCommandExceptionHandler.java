package exception.handler;

import command.Command;
import command.queue.CommandQueue;
import command.wrapper.RepeatCommand;

public class RepeatCommandExceptionHandler implements ExceptionHandler {

    private final CommandQueue commandQueue;

    public RepeatCommandExceptionHandler(CommandQueue commandQueue) {
        this.commandQueue = commandQueue;
    }

    @Override
    public void handle(Command cmd, Exception ex) {
        commandQueue.addCommand(new RepeatCommand(cmd));
    }
}
