import command.Command;
import command.queue.CommandQueue;
import exception.handler.ExceptionHandler;
import exception.handler.factory.ExceptionHandlerFactoryImpl;
import exception.handler.ExceptionHandlerResolver;

public class SpaceBattleApplication {
    private final CommandQueue commandQueue;
    private final ExceptionHandler exceptionHandler;

    public SpaceBattleApplication(CommandQueue commandQueue) {
        this.commandQueue = commandQueue;
        this.exceptionHandler = new ExceptionHandlerResolver(new ExceptionHandlerFactoryImpl(commandQueue));
    }

    public void runApp() {
        while (!commandQueue.isEmpty()) {
            Command cmd = commandQueue.pollCommand();
            try {
                cmd.execute();
            } catch (Exception ex) {
                exceptionHandler.handle(cmd, ex);
            }
        }
    }
}
