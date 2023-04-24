package exception.handler;

import command.Command;
import command.queue.CommandQueue;
import command.wrapper.LogExceptionCommand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class LogExceptionHandlerTest {

    LogExceptionHandler handler;
    CommandQueue commandQueue;

    @BeforeEach
    void setUp() {
        commandQueue = mock(CommandQueue.class);
        handler = new LogExceptionHandler(commandQueue);
    }

    @Test
    @DisplayName("")
    void test1() {
        Command command = mock(Command.class);
        Exception exception = mock(Exception.class);

        handler.handle(command, exception);

        verify(commandQueue).addCommand(any(LogExceptionCommand.class));
    }
}