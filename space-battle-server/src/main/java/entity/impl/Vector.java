package entity.impl;

import java.util.Objects;

public class Vector {
    private double x;
    private double y;

    public Vector(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public static Vector plus(Vector pos, Vector vel) {
        return new Vector(pos.getX() + vel.getX(), pos.getY() + vel.getY());
    }

    public double getX() {
        return x;
    }

    public void setX(double xPos) {
        this.x = xPos;
    }

    public double getY() {
        return y;
    }

    public void setY(double yPos) {
        this.y = yPos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector that = (Vector) o;
        return Double.compare(that.x, x) == 0 && Double.compare(that.y, y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Vector{");
        sb.append("x=").append(x);
        sb.append(", y=").append(y);
        sb.append('}');
        return sb.toString();
    }
}
