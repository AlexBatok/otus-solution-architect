package command.simple;

import command.Command;
import entity.Movable;
import entity.impl.Vector;
import exception.command.MoveCommandException;

public class MoveCommand implements Command {

    private final Movable movable;

    public MoveCommand(Movable movable) {
        this.movable = movable;
    }

    @Override
    public void execute() {
        try {
            movable.setPosition(Vector.plus(movable.getPosition(), movable.getVelocity()));
        } catch (Exception e) {
            throw new MoveCommandException(e);
        }
    }
}
