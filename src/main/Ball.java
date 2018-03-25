package main;

public class Ball {
    private Vector vector;
    private Position2D position;

    public Ball(Vector vector, Position2D position) {
        this.vector = vector;
        this.position = position;
    }

    public Vector getVector() {
        return vector;
    }

    public Position2D getPosition() {
        return position;
    }
}
