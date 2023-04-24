package exception.handler.factory;

import command.Command;
import exception.handler.ExceptionHandler;

/**
 * Интерфейс для фабрики обработчиков ошибок
 */
public interface ExceptionHandlerFactory {
    ExceptionHandler getHandler(Command cmd, Exception ex);
    ExceptionHandler getDefaultHandler();
}
