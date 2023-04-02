package adapter;

import entity.Movable;
import entity.UObject;
import entity.impl.Direction;
import entity.impl.Vector;

public class MovableAdapter implements Movable {
    private final UObject object;

    public MovableAdapter(UObject object) {
        this.object = object;
    }

    @Override
    public Vector getPosition() {
        return (Vector) object.getProperty("Position");
    }

    @Override
    public Vector getVelocity() {
        Direction d = (Direction) object.getProperty("Direction");
        int v = (int) object.getProperty("Velocity");
        return new Vector(
                v * Math.cos((double) d.getPosition() / 360 * d.getDirectionsCount()),
                v * Math.sin((double) d.getPosition() / 360 * d.getDirectionsCount())
        );
    }

    @Override
    public void setPosition(Vector newPosition) {
        object.setProperty("Position", newPosition);
    }
}
