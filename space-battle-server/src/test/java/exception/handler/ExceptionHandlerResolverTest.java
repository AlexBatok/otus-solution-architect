package exception.handler;

import command.Command;
import exception.HandlerNotFoundException;
import exception.handler.factory.ExceptionHandlerFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class ExceptionHandlerResolverTest {
    ExceptionHandlerResolver resolver;
    ExceptionHandlerFactory factory;

    @BeforeEach
    void setUp() {
        factory = mock(ExceptionHandlerFactory.class);
        resolver = new ExceptionHandlerResolver(factory);
    }

    @Test
    @DisplayName("Проверка метода handle (позитивный тест)")
    void test1() {
        ExceptionHandler handler = mock(LogExceptionHandler.class);
        Command cmd = mock(Command.class);
        Exception ex = mock(Exception.class);
        doReturn(handler)
                .when(factory)
                .getHandler(cmd, ex);

        resolver.handle(cmd, ex);

        verify(factory).getHandler(cmd, ex);
        verify(handler).handle(cmd, ex);
    }

    @Test
    @DisplayName("Проверка метода handle (негативный тест): когда выброшено исключение HandlerNotFoundException, " +
            "должен быть вызван метод factory.getDefaultHandler()")
    void test2() {
        ExceptionHandler handler = mock(LogExceptionHandler.class);
        Command cmd = mock(Command.class);
        Exception ex = mock(Exception.class);
        doThrow(new HandlerNotFoundException())
                .when(factory)
                .getHandler(cmd, ex);
        doReturn(handler)
                .when(factory)
                .getDefaultHandler();

        resolver.handle(cmd, ex);

        verify(factory).getHandler(cmd, ex);
        verify(factory).getDefaultHandler();
        verify(handler).handle(cmd, ex);
    }
}