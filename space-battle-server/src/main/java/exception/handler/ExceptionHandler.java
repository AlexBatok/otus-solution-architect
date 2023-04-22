package exception.handler;

import command.Command;

/**
 * Интерфейс обработчика ошибок
 */
public interface ExceptionHandler {
    void handle(Command cmd, Exception ex);
}
