package adapter;

import entity.Rotatable;
import entity.UObject;
import entity.impl.Direction;

public class RotatableAdapter implements Rotatable {

    private final UObject object;

    public RotatableAdapter(UObject object) {
        this.object = object;
    }

    @Override
    public Direction getDirection() {
        return (Direction) object.getProperty("Direction");
    }

    @Override
    public int getAngularVelocity() {
        return (int) object.getProperty("AngularVelocity");
    }

    @Override
    public void setDirection(Direction newDirection) {
        object.setProperty("Direction", newDirection);
    }
}
