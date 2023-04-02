package entity;

import entity.impl.Direction;

public interface Rotatable {
    Direction getDirection();
    int getAngularVelocity();
    void setDirection(Direction newDirection);
}
