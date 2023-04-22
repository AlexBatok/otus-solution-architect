package exception.handler;

import command.Command;
import command.queue.CommandQueue;
import command.simple.MoveCommand;
import command.wrapper.LogExceptionCommand;
import command.wrapper.RepeatCommand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class RepeatCommandThenLogExceptionHandlerTest {

    RepeatCommandThenLogExceptionHandler handler;
    CommandQueue commandQueue;

    @BeforeEach
    void setUp() {
        commandQueue = mock(CommandQueue.class);
        handler = new RepeatCommandThenLogExceptionHandler(commandQueue);
    }

    @Test
    @DisplayName("Проверка метода handle(): если переданная команда не является экземпляром RepeatCommand," +
            "добавить в очередь команд RepeatCommand")
    void test1() {
        Command nonRepeatCommand = mock(MoveCommand.class);
        Exception exception = mock(Exception.class);

        handler.handle(nonRepeatCommand, exception);

        verify(commandQueue).addCommand(any(RepeatCommand.class));
    }

    @Test
    @DisplayName("Проверка метода handle(): если переданная команда является экземпляром RepeatCommand," +
            "добавить в очередь команд LogExceptionCommand")
    void test2() {
        Command repeatCommand = mock(RepeatCommand.class);
        Exception exception = mock(Exception.class);

        handler.handle(repeatCommand, exception);

        verify(commandQueue).addCommand(any(LogExceptionCommand.class));
    }
}