package exception.handler.factory;

import command.Command;
import command.queue.CommandQueue;
import command.simple.BurnFuelCommand;
import exception.HandlerNotFoundException;
import exception.command.BurnFuelCommandException;
import exception.handler.ExceptionHandler;
import exception.handler.LogExceptionHandler;
import exception.handler.RepeatCommandExceptionHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class ExceptionHandlerFactoryImplTest {

    ExceptionHandlerFactory exceptionHandlerFactory;
    CommandQueue commandQueue;

    @BeforeEach
    void setUp() {
        commandQueue = mock(CommandQueue.class);
        exceptionHandlerFactory = new ExceptionHandlerFactoryImpl(commandQueue);
    }

    @Test
    @DisplayName("Проверка метода getHandler: для команды BurnFuelCommand и исключения BurnFuelCommandException " +
            "должен вернуться обработчик RepeatCommandExceptionHandler")
    void test1() {
        Command command = mock(BurnFuelCommand.class);
        Exception exception = mock(BurnFuelCommandException.class);

        ExceptionHandler result = exceptionHandlerFactory.getHandler(command, exception);

        assertTrue(result instanceof RepeatCommandExceptionHandler);
    }

    @Test
    @DisplayName("Проверка метода getHandler: для команды BurnFuelCommand и исключения для которого отсутствует обработчик " +
            "должно быть выброшено исключение HandlerNotFoundException")
    void test2() {
        Command command = mock(BurnFuelCommand.class);
        Exception exception = mock(NullPointerException.class);

        assertThrows(HandlerNotFoundException.class,
                () -> exceptionHandlerFactory.getHandler(command, exception));
    }

    @Test
    @DisplayName("Проверка метода getHandler: для команды, для которой отсутствует обработчик и исключения BurnFuelCommandException " +
            "должно быть выброшено исключение HandlerNotFoundException")
    void test3() {
        Command command = mock(Command.class);
        Exception exception = mock(BurnFuelCommandException.class);

        assertThrows(HandlerNotFoundException.class,
                () -> exceptionHandlerFactory.getHandler(command, exception));
    }

    @Test
    @DisplayName("Проверка метода getDefaultHandler: должен вернуться обработчик LogExceptionHandler")
    void test4() {
        ExceptionHandler result = exceptionHandlerFactory.getDefaultHandler();

        assertTrue(result instanceof LogExceptionHandler);
    }
}