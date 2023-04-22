package command.macro;

import command.Command;
import exception.command.CommandException;

import java.util.List;

public class MacroCommand implements Command {
    private final List<Command> commands;

    public MacroCommand(List<Command> commands) {
        this.commands = commands;
    }

    @Override
    public void execute() {
        for (Command command : commands) {
            try {
                command.execute();
            } catch (Exception e) {
                throw new CommandException(e);
            }
        }
    }
}