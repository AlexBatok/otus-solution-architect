package command.queue;

import command.Command;

import java.util.LinkedList;
import java.util.Queue;

public class CommandQueueImpl implements CommandQueue {
    private final Queue<Command> commands;

    public CommandQueueImpl() {
        this.commands = new LinkedList<>();
    }

    @Override
    public void addCommand(Command command) {
        commands.add(command);
    }

    @Override
    public Command pollCommand() {
        return commands.poll();
    }

    @Override
    public boolean isEmpty() {
        return commands.isEmpty();
    }
}
