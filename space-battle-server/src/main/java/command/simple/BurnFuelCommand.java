package command.simple;

import command.Command;
import entity.Fuelable;
import exception.command.BurnFuelCommandException;

public class BurnFuelCommand implements Command {
    private final Fuelable fuelable;

    public BurnFuelCommand(Fuelable fuelable) {
        this.fuelable = fuelable;
    }

    @Override
    public void execute() {
        try {
            fuelable.setFuelLevel(fuelable.getFuelLevel() - fuelable.getFuelConsumptionRate());
        } catch (Exception e) {
            throw new BurnFuelCommandException(e);
        }
    }
}
