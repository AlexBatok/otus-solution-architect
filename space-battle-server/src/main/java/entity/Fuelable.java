package entity;

public interface Fuelable {
    int getFuelMaxLimit();
    int getFuelLevel();
    void setFuelLevel(int fuelLevel);
    int getFuelConsumptionRate();
}
