package command.simple;

import command.Command;
import entity.Fuelable;
import exception.NotEnoughFuelException;
import exception.command.CheckFuelCommandException;

public class CheckFuelCommand implements Command {
    private final Fuelable fuelable;

    public CheckFuelCommand(Fuelable fuelable) {
        this.fuelable = fuelable;
    }

    @Override
    public void execute() {
        try {
            if (fuelable.getFuelLevel() - fuelable.getFuelConsumptionRate() < 0) {
                throw new NotEnoughFuelException();
            }
        } catch (Exception e) {
            throw new CheckFuelCommandException(e);
        }
    }
}
