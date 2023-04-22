package command.wrapper;

import command.Command;

/**
 * Интерфейс для команд, которые являются обертками над другими командами
 */
public interface CommandWrapper extends Command {
    default Command getSourceCommand() {
        Command sourceCommand = this;
        while (sourceCommand instanceof CommandWrapper) {
            sourceCommand = ((CommandWrapper) sourceCommand).getSourceCommand();
        }
        return sourceCommand;
    }
}
