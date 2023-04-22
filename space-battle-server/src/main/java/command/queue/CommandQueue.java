package command.queue;

import command.Command;

/**
 * Интерфейс для очереди команд
 */
public interface CommandQueue {
    void addCommand(Command command);
    Command pollCommand();
    boolean isEmpty();
}
