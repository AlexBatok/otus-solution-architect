package entity;

import entity.impl.Vector;

public interface Movable {
    Vector getPosition();
    Vector getVelocity();
    void setPosition(Vector newPosition);
}
