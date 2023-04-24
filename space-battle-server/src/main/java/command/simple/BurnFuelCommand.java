package command.simple;

import command.Command;
import entity.Fuelable;

public class BurnFuelCommand implements Command {
    private final Fuelable fuelable;

    public BurnFuelCommand(Fuelable fuelable) {
        this.fuelable = fuelable;
    }

    @Override
    public void execute() {
        fuelable.setFuelLevel(fuelable.getFuelLevel() - fuelable.getFuelConsumptionRate());
    }
}
