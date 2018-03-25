package main;

public class Vector {
    private int magnitude;
    private Position2D direction;
    Vector(int magnitude, Position2D direction) {
        this.magnitude = magnitude;
        this.direction = direction;
    }

    public int getMagnitude() {
        return magnitude;
    }

    public Position2D getDirection() {
        return direction;
    }
}