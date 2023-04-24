package exception.handler;

import command.Command;
import command.wrapper.CommandWrapper;
import exception.HandlerNotFoundException;
import exception.handler.factory.ExceptionHandlerFactory;

public class ExceptionHandlerResolver implements ExceptionHandler {

    private final ExceptionHandlerFactory factory;

    public ExceptionHandlerResolver(ExceptionHandlerFactory factory) {
        this.factory = factory;
    }

    @Override
    public void handle(Command cmd, Exception ex) {
        try {
            if (cmd instanceof CommandWrapper) {
                cmd = ((CommandWrapper) cmd).getSourceCommand();
            }
            factory.getHandler(cmd, ex).handle(cmd, ex);
        } catch (HandlerNotFoundException e) {
            factory.getDefaultHandler().handle(cmd, ex);
        }
    }
}
