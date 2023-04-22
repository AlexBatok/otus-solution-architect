package exception.handler.factory;

import command.Command;
import command.queue.CommandQueue;
import command.simple.*;
import exception.HandlerNotFoundException;
import exception.command.*;
import exception.handler.*;

import java.util.HashMap;
import java.util.Map;

public class ExceptionHandlerFactoryImpl implements ExceptionHandlerFactory {
    private final Map<Class<? extends Command>, Map<Class<? extends Exception>, ExceptionHandler>> handlersMap;
    private final CommandQueue commandQueue;

    public ExceptionHandlerFactoryImpl(CommandQueue commandQueue) {
        this.handlersMap = new HashMap<>();
        this.commandQueue = commandQueue;
        // TODO: 20.04.2023 IOC container
        handlersMap.put(CheckFuelCommand.class, Map.of(CheckFuelCommandException.class, new LogExceptionHandler(commandQueue)));
        handlersMap.put(BurnFuelCommand.class, Map.of(BurnFuelCommandException.class, new RepeatCommandExceptionHandler(commandQueue)));
        handlersMap.put(MoveCommand.class, Map.of(MoveCommandException.class, new RepeatCommandThenLogExceptionHandler(commandQueue)));
        handlersMap.put(RotateCommand.class, Map.of(RotateCommandException.class, new RepeatCommandTwiceThenLogExceptionHandler(commandQueue)));
    }

    @Override
    public ExceptionHandler getHandler(Command cmd, Exception ex) {
        if (handlersMap.get(cmd.getClass()) == null || handlersMap.get(cmd.getClass()).get(ex.getClass()) == null) {
            throw new HandlerNotFoundException();
        }
        return handlersMap.get(cmd.getClass()).get(ex.getClass());
    }

    @Override
    public ExceptionHandler getDefaultHandler() {
        return new LogExceptionHandler(commandQueue);
    }
}
