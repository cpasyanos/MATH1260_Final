package main;

public class Implicit {
    private Vector vector;
    private Position2D point;

    Implicit(Vector vector, Position2D point) {
        this.vector = vector;
        this.point = point;
    }

    public Vector getVector() {
        return vector;
    }

    public Position2D getPoint() {
        return point;
    }
}
