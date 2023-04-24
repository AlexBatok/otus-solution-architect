package exception.handler;

import command.Command;
import command.queue.CommandQueue;
import command.wrapper.LogExceptionCommand;
import command.wrapper.RepeatCommand;
import command.wrapper.TwiceRepeatCommand;

public class RepeatCommandTwiceThenLogExceptionHandler implements ExceptionHandler {
    private final CommandQueue commandQueue;

    public RepeatCommandTwiceThenLogExceptionHandler(CommandQueue commandQueue) {
        this.commandQueue = commandQueue;
    }

    @Override
    public void handle(Command cmd, Exception ex) {
        if (cmd instanceof TwiceRepeatCommand) {
            cmd = ((TwiceRepeatCommand) cmd).getSourceCommand();
            commandQueue.addCommand(new LogExceptionCommand(ex, cmd));
        } else if (cmd instanceof RepeatCommand){
            cmd = ((RepeatCommand) cmd).getSourceCommand();
            commandQueue.addCommand(new TwiceRepeatCommand(cmd));
        } else {
            commandQueue.addCommand(new RepeatCommand(cmd));
        }
    }
}
