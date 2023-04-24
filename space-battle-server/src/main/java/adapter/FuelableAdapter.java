package adapter;

import entity.Fuelable;
import entity.UObject;

public class FuelableAdapter implements Fuelable {

    private final UObject uObject;

    public FuelableAdapter(UObject uObject) {
        this.uObject = uObject;
    }

    @Override
    public int getFuelLevel() {
        return (int) uObject.getProperty("FuelLevel");
    }

    @Override
    public void setFuelLevel(int fuelLevel) {
        uObject.setProperty("FuelLevel", fuelLevel);
    }

    @Override
    public int getFuelMaxLimit() {
        return (int) uObject.getProperty("FuelMaxLimit");
    }

    @Override
    public int getFuelConsumptionRate() {
        return (int) uObject.getProperty("FuelConsumptionRate");
    }
}
