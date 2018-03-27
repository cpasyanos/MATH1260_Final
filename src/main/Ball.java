package main;

public class Ball {
    private Vector vector;
    private Position2D position;
    private int radius;

    public Ball(Vector vector, Position2D position, int radius) {
        this.vector = vector;
        this.position = position;
        this.radius = radius;
    }

    public Vector getVector() {
        return vector;
    }

    public Position2D getPosition() {
        return position;
    }
}

