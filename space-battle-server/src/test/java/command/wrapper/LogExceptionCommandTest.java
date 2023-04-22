package command.wrapper;

import command.Command;
import command.simple.MoveCommand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class LogExceptionCommandTest {

    Command logExceptionCommand;
    Command someCommand;
    Exception exception;

    @BeforeEach
    void setUp() {
        someCommand = mock(MoveCommand.class);
        exception = mock(Exception.class);
        logExceptionCommand = new LogExceptionCommand(exception, someCommand);
    }

    @Test
    void test1() {
        doReturn("exceptionMessage")
                .when(exception)
                .getMessage();

        logExceptionCommand.execute();

        verify(exception).getMessage();
    }
}