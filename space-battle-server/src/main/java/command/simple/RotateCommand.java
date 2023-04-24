package command.simple;

import command.Command;
import entity.Rotatable;

public class RotateCommand implements Command {
    private final Rotatable rotatable;

    public RotateCommand(Rotatable rotatable) {
        this.rotatable = rotatable;
    }

    @Override
    public void execute() {
        rotatable.setDirection(rotatable.getDirection().next(rotatable.getAngularVelocity()));
    }

}
