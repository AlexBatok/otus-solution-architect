package exception.handler;

import command.Command;
import command.queue.CommandQueue;
import command.wrapper.RepeatCommand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class RepeatCommandExceptionHandlerTest {

    RepeatCommandExceptionHandler handler;
    CommandQueue commandQueue;

    @BeforeEach
    void setUp() {
        commandQueue = mock(CommandQueue.class);
        handler = new RepeatCommandExceptionHandler(commandQueue);
    }

    @Test
    void handle() {
        Command command = mock(Command.class);
        Exception exception = mock(Exception.class);

        handler.handle(command, exception);

        verify(commandQueue).addCommand(any(RepeatCommand.class));
    }
}