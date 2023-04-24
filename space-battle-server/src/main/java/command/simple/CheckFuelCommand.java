package command.simple;

import command.Command;
import entity.Fuelable;
import exception.NotEnoughFuelException;

public class CheckFuelCommand implements Command {
    private final Fuelable fuelable;

    public CheckFuelCommand(Fuelable fuelable) {
        this.fuelable = fuelable;
    }

    @Override
    public void execute() {
        if (fuelable.getFuelLevel() - fuelable.getFuelConsumptionRate() < 0) {
            throw new NotEnoughFuelException();
        }
    }
}
