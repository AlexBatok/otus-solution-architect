package command.simple;

import command.Command;
import entity.Rotatable;
import exception.command.RotateCommandException;

public class RotateCommand implements Command {
    private final Rotatable rotatable;

    public RotateCommand(Rotatable rotatable) {
        this.rotatable = rotatable;
    }

    @Override
    public void execute() {
        try {
            rotatable.setDirection(rotatable.getDirection().next(rotatable.getAngularVelocity()));
        } catch (Exception e) {
            throw new RotateCommandException(e);
        }
    }

}
