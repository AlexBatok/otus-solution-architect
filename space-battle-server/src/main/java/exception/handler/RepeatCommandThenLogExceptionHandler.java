package exception.handler;

import command.Command;
import command.queue.CommandQueue;
import command.wrapper.LogExceptionCommand;
import command.wrapper.RepeatCommand;

public class RepeatCommandThenLogExceptionHandler implements ExceptionHandler {

    private final CommandQueue commandQueue;

    public RepeatCommandThenLogExceptionHandler(CommandQueue commandQueue) {
        this.commandQueue = commandQueue;
    }

    @Override
    public void handle(Command cmd, Exception ex) {
        if (cmd instanceof RepeatCommand) {
            cmd = ((RepeatCommand) cmd).getSourceCommand();
            commandQueue.addCommand(new LogExceptionCommand(ex, cmd));
        } else {
            commandQueue.addCommand(new RepeatCommand(cmd));
        }
    }
}
